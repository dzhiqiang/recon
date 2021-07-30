package com.dzq;

public interface CompareFieldResult {
    /**
     * 是否一样
     * @return true:一样，false:不一样
     */
    public boolean equally();

    /**
     * 如果不一样，返回不等时判断的字段是哪个
     * @return
     */
    public Field field();

    /**
     * 核对时主字段值
     * @return
     */
    public Field masterField();

    /**
     * 核对时从字段值
     * @return
     */
    public Field slaverField();

}
