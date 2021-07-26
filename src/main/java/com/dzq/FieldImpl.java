package com.dzq;

import java.math.BigDecimal;

public class FieldImpl implements Field{
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public String type() {
        return null;
    }

    @Override
    public Comparable<? extends Comparable> defaultValue() {
        return "123";
    }

    @Override
    public Comparable<? extends Comparable> value() {
        return new BigDecimal("23");
    }

    @Override
    public boolean nullable() {
        return false;
    }
}
