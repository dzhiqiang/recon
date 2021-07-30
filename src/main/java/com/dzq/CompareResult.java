package com.dzq;

import java.math.BigDecimal;
import java.util.Map;

public interface CompareResult {
    /**
     * 结果批次
     */
    public void setBatchId(String batchId);

    /**
     * 获取批次
     * @return 返回批次
     */
    public String getBatchId();

    /**
     * 主根据某个字段的累计值
     * 比如 amount 总金额: 100.01元
     * 比如 amountDiffCount 金额单边笔数: 100
     *
     * @return
     */
    public Map<ResultType, Combinable> getMasterCombine();

    /**
     * 从根据某个字段的累计值
     * 比如 amount : 100.01元
     *
     * @return
     */
    public Map<ResultType, Combinable> getSlaverCombine();

    /**
     * 类型
     */
    interface ResultType {
        public String name();

        public String type();
    }
}
