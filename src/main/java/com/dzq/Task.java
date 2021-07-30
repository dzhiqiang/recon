package com.dzq;

public interface Task {
    /**
     * 是否暂停
     * @return 暂停状态 true:已暂停 false:未暂停
     */
    public boolean isPause();

    /**
     * 下次执行时间
     * @return 毫秒数
     */
    public long nextRunTime();

    /**
     * 暂停
     * @return 返回是否暂停成功 true:成功，false:失败
     */
    public boolean pause();

    /**
     * 恢复
     * @return 重启是否成功 true:成功，false:失败
     */
    public boolean resume();

    /**
     * 任务运行时的批次
     * @return
     */
    public String batchId();

    /**
     * 运行时的状态
     * @return
     */
    public String state();

    /**
     * 获取对账配置
     * @return 对账配置
     */
    public ReconConfig getReconConfig();

}
