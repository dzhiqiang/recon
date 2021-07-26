package com.dzq;

import java.util.List;

public interface Resolver {
    /**
     * 解析字符串成需要入库的字段
     * @param data 数据
     * @return
     */
    public List<Field> resolve(Data data);

}
