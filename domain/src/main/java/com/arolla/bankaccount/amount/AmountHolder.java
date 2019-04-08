package com.arolla.bankaccount.amount;

public class AmountHolder {

    private Amount amount;

    public AmountHolder(Amount amount) {

        this.amount = amount;
    }

    public Amount incrementAndGet(Amount otherAmount){
        this.amount = amount.plus(otherAmount);
        return this.amount;
    }
}
