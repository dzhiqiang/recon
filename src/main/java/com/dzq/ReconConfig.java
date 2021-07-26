package com.dzq;

import java.util.List;

public interface ReconConfig {
    // 获取配置唯一键
    public long getId();
    // 对账名称
    public String getName();
    // 对账模式 双边对账，单边对账
    public String getModel();

    public String getCycle();

    public List<Field> getBaseFields();

    public List<Field> getCompareFields();






}
