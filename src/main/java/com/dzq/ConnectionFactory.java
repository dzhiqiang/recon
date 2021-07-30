package com.dzq;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ConnectionFactory {

	public static final String[] PROPERTIES = new String[]{
		"druid.url", "druid.username", "druid.password", "druid.maxActive","druid.driverClassName"
	};

	private static Map<Long, DruidDataSource> poolCache = new HashMap<>();

	private static ReadWriteLock lock = new ReentrantReadWriteLock();

	public static Connection getConnection(DbDataSourceConfig dbDataSourceConfig) throws SQLException {
		DruidDataSource dataSource = getDataSourceInstance(dbDataSourceConfig);
		return dataSource.getConnection();
	}

	private static DruidDataSource getDataSourceInstance(DbDataSourceConfig dbDataSourceConfig) {
		DruidDataSource dataSource = poolCache.get(dbDataSourceConfig.getId());
		if (dataSource == null) {
			dataSource = maybeInit(dbDataSourceConfig);
		}
		return dataSource;
	}

	private static DruidDataSource maybeInit(DbDataSourceConfig dbDataSourceConfig) {
		lock.readLock().lock();
		DruidDataSource dataSource = poolCache.get(dbDataSourceConfig.getId());
		try {
			if (dataSource == null) {
				lock.readLock().unlock();
				lock.writeLock().lock();
				dataSource = poolCache.get(dbDataSourceConfig.getId());
				try {
					if (dataSource == null) {
						dataSource = createDruidDataSoure(dbDataSourceConfig);
						poolCache.put(dbDataSourceConfig.getId(), dataSource);
					}
				}finally {
					lock.writeLock().unlock();
					lock.readLock().lock();
				}

			}
		}finally {
			lock.readLock().unlock();
		}

		return dataSource;
	}

	private static DruidDataSource createDruidDataSoure(DbDataSourceConfig dbDataSourceConfig) {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.configFromPropety(loadProperties(dbDataSourceConfig));
		return dataSource;
	}

	private static Properties loadProperties(DbDataSourceConfig dbDataSourceConfig) {
		Properties prop = new Properties();

		prop.setProperty("druid.url", dbDataSourceConfig.getUrl());
		prop.setProperty("druid.username", dbDataSourceConfig.getUsername());
		prop.setProperty("druid.password", dbDataSourceConfig.getPassword());

		return prop;
	}

}
