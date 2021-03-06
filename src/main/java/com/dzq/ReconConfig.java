package com.dzq;

import java.util.List;

public interface ReconConfig extends Task{
    // 获取配置唯一键
    public long getId();
    // 对账名称
    public String getName();
    // 对账模式 双边对账，单边对账
    public String getModel();
    /**
     * 对账周期
     * @return 周期 T ,D ,H
     */
    public String getCycle();

    /**
     * 执行时间 08:00 每天8点执行 15 每小时15分执行
     * @return
     */
    public String runTime();

    /**
     * 最基本的对账字段，会根据最基本的字段排序
     * @return
     */
    public List<Field> getBaseFields();
    /**
     * 其他比对字段，其他比对字段如果不等，则认为是双边不等
     * @return
     */
    public List<Field> getCompareFields();

    /**
     * 主数据源配置
     * @return 数据源配置
     */
    public DataRepositoryConfig masterDataRepositoryConfig();

    /**
     * 从数据源配置
     * @return 数据源配置
     */
    public DataRepositoryConfig slaverDataRepositoryConfig();

    /**
     * 主数据仓库的数据源
     * @return 数据源配置
     */
    public DataRepositoryConfig masterCompareDataRepositoryConfig();

    /**
     * 主数据仓库的数据源
     * @return 数据源配置
     */
    public DataRepositoryConfig slaverCompareDataRepositoryConfig();

    /**
     * 对账结果数据源
     * @return 数据源配置
     */
    public DataRepositoryConfig reconDataRepositoryConfig();

    /**
     * 主数据列信息
     * @return 字段信息
     */
    public List<Field> masterData();
    /**
     * 从数据列信息
     * @return 字段信息
     */
    public List<Field> slaverData();

    /**
     * 数据过滤器
     * @return 过滤器
     */
    public List<Filter> masterFilter();

    /**
     * 数据过滤器
     * @return 过滤器
     */
    public List<Filter> slaverFilter();

    /**
     * 转换器
     * @return 转换器
     */
    public Resolver masterResolver();
    /**
     * 转换器
     * @return 转换器
     */
    public Resolver slaverResolver();

}
