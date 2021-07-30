package com.dzq.util;

import com.dzq.Field;

import java.util.List;

public class SqlUtil {

    public static String selectSql(String tableName, List<Field> columnList, List<Field> whereList, List<Field> orderList, int pageSize) {

        if (tableName == null || tableName.trim().length() == 0) {
            throw new IllegalArgumentException("selectSql columnList is null");
        }
        if (columnList == null || columnList.size() == 0) {
            throw new IllegalArgumentException("selectSql tableName:"+ tableName +" columnList is null");
        }

        if (whereList == null || whereList.size() == 0) {
            throw new IllegalArgumentException("selectSql tableName:"+ tableName +" whereList is null");
        }

        if (pageSize < 0) {
            throw new IllegalArgumentException("selectSql tableName:" + tableName + " pageSize < 0");
        }


        StringBuffer sb = new StringBuffer("select ");

        for (int i = 0; i < columnList.size(); i++) {
            sb.append(columnList.get(i).getKey());
            if (i < columnList.size() - 1) {
                sb.append(" , ");
            }
        }
        sb.append(" from ").append(tableName).append(" where ");
        for (int i = 0; i < whereList.size(); i++) {
            sb.append(whereList.get(i).getKey()).append(" = ").append(" ? ");
            if (i < whereList.size() - 1) {
                sb.append(" and ");
            }
        }

        if (orderList != null && orderList.size() > 0) {
            sb.append(" order by ");
            for (int i = 0; i < orderList.size(); i++) {
                sb.append(orderList.get(i).getKey());
                if (i < orderList.size() - 1) {
                    sb.append(",");
                }
            }
        }

        if (pageSize > 0) {
            sb.append(" limit ?, ?");
        }
        return sb.toString();
    }

}
