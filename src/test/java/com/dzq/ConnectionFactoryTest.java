package com.dzq;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactoryTest {
    @Test
    public void test_01() throws SQLException {
        long id = 0l;
        String type = "mysql";
        String url = "jdbc:mysql://localhost:3306/activiti?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
        String username = "root";
        String password = "root";
        DbDataSourceConfig dbDataSourceConfig = new DbDataSourceConfig();
        dbDataSourceConfig.setId(id);
        dbDataSourceConfig.setPassword(password);
        dbDataSourceConfig.setType(type);
        dbDataSourceConfig.setUrl(url);
        dbDataSourceConfig.setUsername(username);
        Connection connection = ConnectionFactory.getConnection(dbDataSourceConfig);
        PreparedStatement statement = connection.prepareStatement("select * from ACT_ID_GROUP");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String idStr = resultSet.getString("id_");
            System.out.println(idStr);
        }
    }

}
