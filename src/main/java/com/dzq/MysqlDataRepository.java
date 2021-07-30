package com.dzq;

import com.dzq.util.SqlUtil;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlDataRepository implements DataRepository {

    private DbDataSourceConfig dbDataSourceConfig;
    private List<Field> columnList;
    private String tableName;
    private List<Field> orderList;
    private int pageSize;
    private int currentIndex;
    private List<Filter> filters;
    private boolean stop;



    public MysqlDataRepository(DbDataSourceConfig config, MysqlCondition mysqlCondition, List<Filter> filters) {
        this.dbDataSourceConfig = config;
        this.filters = filters;
        this.columnList = mysqlCondition.getColumnList();
        this.tableName = mysqlCondition.getTableName();
        this.orderList = mysqlCondition.getOrderList();
        this.pageSize = mysqlCondition.getPageSize();
        this.currentIndex = 0;
        this.stop = false;
    }

    @Override
    public List<Data> getListData(List<Field> whereList) {
        if (stop) {
            return null;
        }
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.getConnection(this.dbDataSourceConfig);
            String sql = SqlUtil.selectSql(tableName, columnList, whereList, orderList, pageSize);
            statement = connection.prepareStatement(sql);
            int i = 1;
            for (Field field : whereList) {
                setValue(i++, field, statement);
            }
            if (pageSize > 0) {
                statement.setInt(i++, currentIndex);
                statement.setInt(i++, pageSize);
            }
            resultSet = statement.executeQuery();
            List<Data> dataList = new ArrayList<>();
            int count = 0;
            while (resultSet.next()) {
                count++;
                ListData data = new ListData();
                for (Field field : columnList) {
                    data.add(new FieldImpl(field.getKey(), field.type(), value(resultSet, field)));
                }
                filter(data);
                dataList.add(data);
            }
            this.stop = count < this.pageSize;
            this.currentIndex += this.pageSize;
            return dataList;
        } catch (SQLException e1) {
            throw new RuntimeException(e1);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e2) {
                    throw new RuntimeException(e2);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e2) {
                    throw new RuntimeException(e2);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
    }

    private boolean filter(ListData data) {
        if (this.filters == null) {
            return true;
        }
        for (Filter filter : this.filters) {
            if (!filter.filter(data.getData())) {
                return false;
            }
        }
        return true;
    }

    private Comparable value(ResultSet resultSet, Field field) throws SQLException {

        if ("String".equals(field.type())) {
            return resultSet.getString(field.getKey());
        }

        if ("Long".equals(field.type())) {
            return resultSet.getLong(field.getKey());
        }

        if ("Date".equals(field.type())) {
            return resultSet.getDate(field.getKey());
        }

        if ("BigDecimal".equals(field.type())) {
            return resultSet.getBigDecimal(field.getKey());
        }

        if ("Int".equals(field.type())) {
            return resultSet.getInt(field.getKey());
        }

        if ("Byte".equals(field.type())) {
            return resultSet.getByte(field.getKey());
        }

        if ("Short".equals(field.type())) {
            return resultSet.getShort(field.getKey());
        }

        throw new RuntimeException("field type: " + field.type() + " is not exist");
    }

    private void setValue(int index, Field field, PreparedStatement statement) throws SQLException {

        if ("String".equals(field.type())) {
            statement.setString(index, (String) field.value());
        }
        if ("Long".equals(field.type())) {
            statement.setLong(index, (Long) field.value());
        }
        if ("Date".equals(field.type())) {
            statement.setDate(index, (Date) field.value());
        }

        if ("BigDecimal".equals(field.type())) {
            statement.setBigDecimal(index, (BigDecimal) field.value());
        }

        if ("Int".equals(field.type())) {
            statement.setInt(index, (Integer) field.value());
        }
        if ("Byte".equals(field.type())) {
            statement.setByte(index, (Byte) field.value());
        }

        if ("Short".equals(field.type())) {
            statement.setShort(index, (Short) field.value());
        }

    }


    @Override
    public int saveList(List<Data> dataList) {
        return 0;
    }

    @Override
    public int save(Data data) {
        return 0;
    }

    @Override
    public Data getData(Field field) {
        return null;
    }

    @Override
    public int update(Field field) {
        return 0;
    }

    @Override
    public int updateMultiple(List<Field> fieldList) {
        return 0;
    }

    @Override
    public boolean stop() {
        return this.stop;
    }

}
