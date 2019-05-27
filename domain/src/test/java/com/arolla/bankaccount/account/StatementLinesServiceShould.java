package com.arolla.bankaccount.account;

import com.arolla.bankaccount.statement.StatementLine;
import com.arolla.bankaccount.statement.StatementLinesService;
import org.junit.jupiter.api.*;

import java.util.List;

import static com.arolla.bankaccount.account.OperationType.DEPOSIT;
import static com.arolla.bankaccount.account.OperationType.WITHDRAW;
import static com.arolla.bankaccount.amount.Amount.amountOf;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("The StatementLine Service Should")
public class StatementLinesServiceShould {

    private static final int FIRST_ELEMENT = 0;
    private static final int SECOND_ELEMENT = 1;
    private static final int THIRD_ELEMENT = 2;
    private StatementLinesService statementLinesService;

    @BeforeEach
    void initialize() {
        statementLinesService = new StatementLinesService();
    }


    @Test
    void compute_statements_lines() {
        //given
        List<Operation> operations = asList(
                new Operation("14/03/2019", amountOf(500), DEPOSIT)
                ,
                new Operation("16/03/2019", amountOf(400), WITHDRAW)
                ,
                new Operation("14/04/2019", amountOf(500),
                        DEPOSIT));

        //when
        List<StatementLine> statementLines = statementLinesService.computeStatementLines(operations);

        assertAll(
                () -> assertThat(new StatementLine("14/03/2019", amountOf(500), amountOf(500)), is(statementLines.get(FIRST_ELEMENT))),
                () -> assertThat(new StatementLine("16/03/2019", amountOf(-400), amountOf(100)), is(statementLines.get(SECOND_ELEMENT))),
                () -> assertThat(new StatementLine("14/04/2019", amountOf(500), amountOf(600)), is(statementLines.get(THIRD_ELEMENT))));

    }

}