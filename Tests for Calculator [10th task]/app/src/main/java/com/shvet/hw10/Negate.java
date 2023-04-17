package com.shvet.hw10;

public class Negate implements Expression {
    private final Expression expr;

    public Negate(Expression expr) {
        this.expr = expr;
    }

    @Override
    public Double evaluate() {
        return -expr.evaluate();
    }
}
