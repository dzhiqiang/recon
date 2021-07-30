package com.dzq;

import java.util.Map;

public class DefaultCompareResult implements CompareResult {

    private String batchId;

    @Override
    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    @Override
    public String getBatchId() {
        return this.batchId;
    }

    @Override
    public Map<ResultType, Combinable> getMasterCombine() {
        return null;
    }

    @Override
    public Map<ResultType, Combinable> getSlaverCombine() {
        return null;
    }
}
