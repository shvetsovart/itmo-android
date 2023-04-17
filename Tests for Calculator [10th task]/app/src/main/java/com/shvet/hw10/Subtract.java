package com.shvet.hw10;

public class Subtract extends AbstractOperation {

    public Subtract(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected Double evaluateImpl(Double leftRes, Double rightRes) {
        return leftRes - rightRes;
    }
}