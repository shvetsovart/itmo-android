package com.shvet.calculator_hw1;

public class Multiply extends AbstractOperation {

    public Multiply(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected Double evaluateImpl(Double leftRes, Double rightRes) {
        return leftRes * rightRes;
    }
}
