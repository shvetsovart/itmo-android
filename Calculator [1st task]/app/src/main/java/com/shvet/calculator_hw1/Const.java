package com.shvet.calculator_hw1;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Const implements Expression {
    private final Double value;

    public Const(String value) {
        this.value = Double.parseDouble(value);
    }

    @NonNull
    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Const aConst = (Const) o;
        return Objects.equals(value, aConst.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public Double evaluate() {
        return this.value;
    }
}
