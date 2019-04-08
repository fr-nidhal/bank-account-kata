package com.arolla.bankaccount;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateHandler {

    private static final String DD_MM_YYYY = "dd/MM/yyyy";
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DD_MM_YYYY);

    public String today() {
        LocalDate today = localDate();
        return today.format(formatter);
    }

    protected LocalDate localDate() {
        return LocalDate.now();

    }
}
