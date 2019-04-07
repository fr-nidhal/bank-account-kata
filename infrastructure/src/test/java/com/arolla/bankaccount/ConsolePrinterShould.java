package com.arolla.bankaccount;

import com.arolla.bankaccount.core.Amount;
import com.arolla.bankaccount.core.Operation;
import com.arolla.bankaccount.core.StatementLine;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.arolla.bankaccount.core.Amount.amountOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ConsolePrinterShould {

    @Mock
    Console console;
    private ConsolePrinter consolePrinter;

    @Before
    public void initialize() {
        consolePrinter = new ConsolePrinter(console);
    }


    @Test
    public void always_print_the_header() {
        //when
        consolePrinter.print(Collections.emptyList());

        //then
        verify(console).printLine("Date | AMOUNT | BALANCE");

    }

    @Test
    public void print_statements_lines_in_reverse_chronological_order() {
        //given

        List<StatementLine> statementLines = transactionsContaining(
                new StatementLine("10/02/2019", amountOf(300), amountOf(300)),
                new StatementLine("26/03/2019", amountOf(400), amountOf(700)),
                new StatementLine("26/04/2019", amountOf(-500), amountOf(200))
        );

        //when
        consolePrinter.print(statementLines);

        //then
        InOrder inOrder = inOrder(console);

        inOrder.verify(console).printLine("Date | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("26/04/2019 | -500,00 | 200,00");
        inOrder.verify(console).printLine("26/03/2019 | 400,00 | 700,00");
        inOrder.verify(console).printLine("10/02/2019 | 300,00 | 300,00");

    }

    private List<StatementLine> transactionsContaining(StatementLine... statementLines) {
        return Arrays.asList(statementLines);
    }

}