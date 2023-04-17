package com.shvet.calculator_hw1;

import java.util.Objects;

public abstract class AbstractOperation implements Expression {
    protected Expression left, right;

    public AbstractOperation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractOperation that = (AbstractOperation) o;
        return Objects.equals(left, that.left) && Objects.equals(right, that.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public Double evaluate() {
        Double leftRes = left.evaluate(), rightRes = right.evaluate();
        return evaluateImpl(leftRes, rightRes);
    }

    protected abstract Double evaluateImpl(Double leftRes, Double rightRes);
}
