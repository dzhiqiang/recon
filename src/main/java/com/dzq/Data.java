package com.dzq;

public interface Data<T> {
    /**
     * 数据类型
     * @return
     */
    public String dataType();

    /**
     * 得到数据
     * @return
     */
    public T getData();

    /**
     * 根据字段获取值
     * @param property
     * @return
     */
    public Field getField(String property);

}
