package com.arolla.bankaccount.core;

import java.util.Objects;

public class StatementLine {
    private final String date;
    private final Amount amount;
    private final Amount balance;

    public StatementLine(String date, Amount amount, Amount balance) {

        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public String date() {
        return date;
    }

    public Amount amount() {
        return amount;
    }

    public Amount balance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatementLine that = (StatementLine) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, balance);
    }

    @Override
    public String toString() {
        return "StatementLine{" +
                "date='" + date + '\'' +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }
}
