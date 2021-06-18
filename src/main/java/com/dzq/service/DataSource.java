package com.dzq.service;

import java.util.List;

/**
 * 对账数据源，推送数据
 */
public interface DataSource {
    /**
     * 推送一条
     */
    public void push(String msg);
    /**
     * 推送多条
     */
    public void batchPush(List<String> msg);
    /**
     * 目前返回数量
     */
    public long count();

}
