package com.arolla.bankaccount.core;

import java.util.Objects;

public class Operation {
    private final String date;
    private final Amount amount;

    public Amount amount() {
        return amount;
    }



    public String date() {
        return date;
    }

    public Operation(String date, Amount amount) {

        this.date = date;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Objects.equals(date, operation.date) &&
                Objects.equals(amount, operation.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount);
    }
}
