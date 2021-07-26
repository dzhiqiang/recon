package com.dzq;

public interface DataSourceConfig {

    public long getId();
    /**
     * 链接方式
     * @return mysql
     */
    public String getType();

    /**
     * 测试是否联通
     * @return true:联通，false:不通
     */
    public boolean test();

}
