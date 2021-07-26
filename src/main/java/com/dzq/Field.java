package com.dzq;

public interface Field {
    /**
     * 全局唯一
     * @return 返回id
     */
    public long getId();

    /**
     * 比如：姓名
     * @return 字段名称
     */
    public String getName();

    /**
     * 字段名,比如：name
     * @return
     */
    public String getKey();

    /**
     * 最大长度，字符
     * @return
     */
    public int length();

    /**
     * 类型，String,Int等
     * @return
     */
    public String type();

    /**
     * 为空时的默认值，设置的时候和取得的时候
     * @return
     */
    public Comparable<? extends Comparable> defaultValue();
    /**
     * 字段值,真正使用的值
     * @return
     */
    public Comparable<? extends Comparable> value();

    /**
     * 是否可以为空
     * @return 是否可以为空
     */
    public boolean nullable();

}
