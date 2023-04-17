package com.shvet.hw10;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Add extends AbstractOperation {

    public Add(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected Double evaluateImpl(Double leftRes, Double rightRes) {
        return leftRes + rightRes;
    }
}
