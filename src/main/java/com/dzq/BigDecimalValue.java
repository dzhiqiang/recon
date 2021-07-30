package com.dzq;

import java.math.BigDecimal;

public class BigDecimalValue implements Combinable{

    private BigDecimal value;

    public BigDecimalValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public Combinable combine(Combinable combinable) {
        BigDecimalValue combine = (BigDecimalValue) combinable;
        return new BigDecimalValue(value().add(combine.value()));
    }

    public BigDecimal value() {
        return this.value;
    }
}
