package com.dzq;

/**
 * 可组合的，组合成一个新值
 */
public interface Combinable {

    public Combinable combine(Combinable combinable);

}
