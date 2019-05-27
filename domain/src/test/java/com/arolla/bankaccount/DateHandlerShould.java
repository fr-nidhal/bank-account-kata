package com.arolla.bankaccount;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("The Date Handler Should")
public class DateHandlerShould {

    private static final String TODAY = "08/04/2019";
    private DateHandler dateService;

    @BeforeEach
    void initialize() {
        dateService = new DateHandlerStub();
    }

    @Test
    void return_today_as_a_string() {

        String date = dateService.today();
        assertThat(date, is(TODAY));
    }

    private class DateHandlerStub extends DateHandler {

        @Override
        protected LocalDate localDate() {
            return LocalDate.of(2019, 4, 8);
        }

    }

}