package com.dzq;

public interface Compare {
    /**
     * 根据对账步骤核对数据
     * @param step
     * @return
     */
    public CompareResult compare(Step step);

}
