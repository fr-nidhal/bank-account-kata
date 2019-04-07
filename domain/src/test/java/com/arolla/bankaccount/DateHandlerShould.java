package com.arolla.bankaccount;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DateHandlerShould {

    private static final String TODAY = "08/04/2019";
    private DateHandler dateService;

    @Before
    public void initialize() throws Exception {
        dateService = new DateHandler();
    }

    @Test
    public void return_today_as_a_string() {

        String date = dateService.today();

        assertThat(date,is(TODAY));
    }

    private class DateHandlerTest extends DateHandler {

        @Override
        protected LocalDate localDate() {
            return LocalDate.of(2019, 4, 8);
        }

    }

}