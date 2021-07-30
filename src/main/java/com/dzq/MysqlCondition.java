package com.dzq;

import java.util.List;

public class MysqlCondition implements Condition{

    private String type;
    private List<Field> columnList;
    private String tableName;
    private List<Field> orderList;
    private int pageSize;

    public List<Field> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<Field> columnList) {
        this.columnList = columnList;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Field> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Field> orderList) {
        this.orderList = orderList;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String type() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
