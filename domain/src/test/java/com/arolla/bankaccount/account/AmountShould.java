package com.arolla.bankaccount.account;

import com.arolla.bankaccount.amount.Amount;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.arolla.bankaccount.amount.Amount.amountOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("The Amount Should")
public class AmountShould {

    @Test
    public void return_the_negative_value_of_an_amount() {


        Amount ten = amountOf(10);
        assertThat(amountOf(-10), is(ten.negative()));

    }

    @Test
    public void return_the_sum_of_amounts() {
        Amount seven = amountOf(7);
        Amount ten = amountOf(10);

        Amount seventeen = amountOf(17);

        assertThat(seventeen, Is.is(equalTo(ten.plus(seven))));
    }

    @Test
    public void should_statically_initialise_an_amount() {
        assertThat(new Amount(new BigDecimal(10)), is(amountOf(10)));
    }


}