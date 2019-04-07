package com.arolla.bankaccount.core;

import java.text.DecimalFormat;
import java.util.Objects;

public class Amount {
    private int value;

    public Amount(int value) {
        this.value = value;
    }

    public Amount negative() {
        return new Amount(-value);
    }

    public Amount plus(Amount amount){
        return new Amount(value+ amount.value);
    }


    public static Amount amountOf(int value){
        return new Amount(value);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return value == amount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


    public String format(DecimalFormat decimalFormat) {
        return decimalFormat.format(value);
    }

    @Override
    public String toString() {
        return "Amount{" +
                "value=" + value +
                '}';
    }
}
