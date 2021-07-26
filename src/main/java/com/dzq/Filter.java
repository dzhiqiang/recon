package com.dzq;

import java.util.List;

/**
 * 过滤条件
 */
public interface Filter {
    /**
     * 过滤
     * @param fields 需要存入库的字段
     * @return
     */
    public boolean filter(List<Field> fields);

}
