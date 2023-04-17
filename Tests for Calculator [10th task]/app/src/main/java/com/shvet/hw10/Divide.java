package com.shvet.hw10;

public class Divide extends AbstractOperation {

    public Divide(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected Double evaluateImpl(Double leftRes, Double rightRes) {
        return leftRes / rightRes;
    }
}
