package com.arolla.bankaccount.amount;

import org.junit.Test;

import static com.arolla.bankaccount.amount.Amount.amountOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AmountHolderShould {


    @Test
    public void increment_and_return_a_mutable_amount(){
        AmountHolder holder = new AmountHolder(amountOf(200));
        assertThat(holder.incrementAndGet(amountOf(300)),is(amountOf(500)));
    }

}