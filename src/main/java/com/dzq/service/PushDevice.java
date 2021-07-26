package com.dzq.service;

import java.util.List;

/**
 * 数据推送装置
 */
public interface PushDevice {
    /**
     * 推送一条
     */
    public void push(String msg);
    /**
     * 推送多条
     */
    public void batchPush(List<String> msg);
    /**
     * 返回推送数量
     */
    public long count();

}
