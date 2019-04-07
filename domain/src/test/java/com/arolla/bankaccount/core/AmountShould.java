package com.arolla.bankaccount.core;

import com.arolla.bankaccount.core.Amount;
import org.hamcrest.core.Is;
import org.junit.Test;

import static com.arolla.bankaccount.core.Amount.amountOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class AmountShould {

    @Test
    public void return_the_negative_value() {

        Amount minusTen = new Amount(-10);
        assertThat(new Amount(10), is(minusTen.negative()));


    }

    @Test
    public void
    return_the_sum_of_amounts() {
        Amount seven = amountOf(7);
        Amount ten = amountOf(10);

        Amount seventeen = amountOf(17);

        assertThat(seventeen, Is.is(equalTo(ten.plus(seven))));
    }

    @Test
    public void
    should_statically_initialise_an_amount() {
        assertThat(new Amount(10), is(amountOf(10)));
    }


}