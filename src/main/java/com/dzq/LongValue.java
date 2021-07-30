package com.dzq;

public class LongValue implements Combinable{

    private long value;

    public LongValue(long value) {
        this.value = value;
    }

    @Override
    public Combinable combine(Combinable combinable) {
        LongValue combine = (LongValue) combinable;
        return new LongValue(combine.value() + this.value);
    }

    public long value() {
        return value;
    }

}
