package com.shvet.shindows;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        try {
            Double value = evaluateImpl(leftRes, rightRes);

            Double fixedPrecisionValue = BigDecimal.valueOf(value)
                    .setScale(10, RoundingMode.HALF_UP)
                    .doubleValue();
            if (value.equals(fixedPrecisionValue)) {
                return value;
            } else {
                return fixedPrecisionValue;
            }
        } catch (ArithmeticException e) {
            return Double.POSITIVE_INFINITY;
        }
    }

    protected abstract Double evaluateImpl(Double leftRes, Double rightRes);
}
