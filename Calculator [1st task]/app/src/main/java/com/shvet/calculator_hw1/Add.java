package com.shvet.calculator_hw1;

public class Add extends AbstractOperation {

    public Add(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected Double evaluateImpl(Double leftRes, Double rightRes) {
        return leftRes + rightRes;
    }
}
