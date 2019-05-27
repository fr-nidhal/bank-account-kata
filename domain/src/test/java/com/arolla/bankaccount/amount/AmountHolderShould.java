package com.arolla.bankaccount.amount;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static com.arolla.bankaccount.amount.Amount.amountOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("The Amount Holder Should")
public class AmountHolderShould {


    @Test
    void increment_and_return_a_mutable_amount() {
        AmountHolder holder = new AmountHolder(amountOf(200));
        assertThat(holder.incrementAndGet(amountOf(300)), is(amountOf(500)));
    }

}