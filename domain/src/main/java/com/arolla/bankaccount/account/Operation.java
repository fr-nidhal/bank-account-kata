package com.arolla.bankaccount.account;

import com.arolla.bankaccount.amount.Amount;

import java.util.Objects;

public class Operation {


    private final String date;
    private OperationType operationType;
    private final Amount amount;

    public Amount amount() {
        return amount;
    }
    public String date() {
        return date;
    }

    public Operation(String date, Amount amount, OperationType operationType) {
        this.date = date;
        this.operationType = operationType;
        this.amount = operationType == OperationType.DEPOSIT ? amount : amount.negative();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Objects.equals(date, operation.date) &&
                operationType == operation.operationType &&
                Objects.equals(amount, operation.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, operationType, amount);
    }
}
