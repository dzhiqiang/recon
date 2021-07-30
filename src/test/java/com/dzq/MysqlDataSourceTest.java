package com.dzq;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MysqlDataSourceTest {
    @Test
    public void test_01() {
        long id = 0l;
        String type = "mysql";
        String url = "jdbc:mysql://10.9.224.45:3306/activiti?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
        String username = "root";
        String password = "root";
        List<Field> columnList = new ArrayList<>();
        Field columnFile1 = new FieldImpl("id_", "String", "");
        columnList.add(columnFile1);
        String tableName = "ACT_ID_GROUP";
        List<Field> orderList = new ArrayList<>();
        int pageSize = 20;
        DbDataSourceConfig dbDataSourceConfig = new DbDataSourceConfig();
        dbDataSourceConfig.setId(id);
        dbDataSourceConfig.setPassword(password);
        dbDataSourceConfig.setType(type);
        dbDataSourceConfig.setUrl(url);
        dbDataSourceConfig.setUsername(username);
        MysqlCondition mysqlCondition = new MysqlCondition();
        mysqlCondition.setColumnList(columnList);
        mysqlCondition.setOrderList(orderList);
        mysqlCondition.setPageSize(pageSize);
        mysqlCondition.setTableName(tableName);
        mysqlCondition.setType(type);
        MysqlDataRepository dataSource = new MysqlDataRepository(dbDataSourceConfig, mysqlCondition, null);
        List<Field> whereList = new ArrayList<>();
        Field whereColumn1 = new FieldImpl("NAME_", "String", "Superusers");
        whereList.add(whereColumn1);
        List<Data> dataList = dataSource.getListData(whereList);

        System.out.println(dataList);

    }

    @Test
    public void test_02() {
        long id = 0l;
        String type = "mysql";
        String url = "jdbc:mysql://10.9.224.45:3306/activiti?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
        String username = "root";
        String password = "root";
        List<Field> columnList = new ArrayList<>();
        Field columnFile1 = new FieldImpl("id", "Long", "");
        Field columnFile2 = new FieldImpl("flow_id", "String", "");
        Field columnFile3 = new FieldImpl("node_id", "String", "");
        columnList.add(columnFile1);
        columnList.add(columnFile2);
        columnList.add(columnFile3);
        String tableName = "transaction";
        List<Field> orderList = new ArrayList<>();
        int pageSize = 20;
        DbDataSourceConfig dbDataSourceConfig = new DbDataSourceConfig();
        dbDataSourceConfig.setId(id);
        dbDataSourceConfig.setPassword(password);
        dbDataSourceConfig.setType(type);
        dbDataSourceConfig.setUrl(url);
        dbDataSourceConfig.setUsername(username);
        MysqlCondition mysqlCondition = new MysqlCondition();
        mysqlCondition.setColumnList(columnList);
        mysqlCondition.setOrderList(orderList);
        mysqlCondition.setPageSize(pageSize);
        mysqlCondition.setTableName(tableName);
        mysqlCondition.setType(type);
        MysqlDataRepository dataSource = new MysqlDataRepository(dbDataSourceConfig, mysqlCondition, null);
        List<Field> whereList = new ArrayList<>();
        Field whereColumn1 = new FieldImpl("node_id", "String", "789");
        whereList.add(whereColumn1);
        List<Data> dataList = dataSource.getListData(whereList);

        System.out.println(dataList);

    }

}
