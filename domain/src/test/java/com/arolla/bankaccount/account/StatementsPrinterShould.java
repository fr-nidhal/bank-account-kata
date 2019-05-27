package com.arolla.bankaccount.account;

import com.arolla.bankaccount.statement.StatementLine;
import com.arolla.bankaccount.statement.StatementLinesService;
import com.arolla.bankaccount.statement.StatementsPrinter;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.arolla.bankaccount.account.OperationType.DEPOSIT;
import static com.arolla.bankaccount.amount.Amount.amountOf;
import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("The Statement Printer Should")
public class StatementsPrinterShould {

    private StatementsPrinter statementsPrinter;
    @Mock
    StatementLinesService statementLinesService;
    @Mock
    Printer printer;

    @BeforeEach
    void initialize() {
        statementsPrinter = new StatementsPrinter(statementLinesService, printer);
    }


    @Test
    void print_all_statements() {

        List<Operation> operations = asList(new Operation("07/04/2019", amountOf(300), DEPOSIT));

        List<StatementLine> statementLines = asList(new StatementLine("07/04/2019", amountOf(300), amountOf(300)));

        given(statementLinesService.computeStatementLines(operations)).willReturn(statementLines);

        statementsPrinter.printStatementsFrom(operations);

        verify(statementLinesService).computeStatementLines(operations);
        verify(printer).print(statementLines);
    }

}