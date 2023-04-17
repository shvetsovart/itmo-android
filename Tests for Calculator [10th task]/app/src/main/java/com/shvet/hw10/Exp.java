package com.shvet.hw10;

public class Exp extends AbstractOperation {

    public Exp(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected Double evaluateImpl(Double leftRes, Double rightRes) {
        return Math.pow(leftRes, rightRes);
    }
}
