package com.arolla.bankaccount;

import com.arolla.bankaccount.core.Amount;
import com.arolla.bankaccount.core.Operation;
import com.arolla.bankaccount.core.Printer;
import com.arolla.bankaccount.core.StatementLine;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static com.arolla.bankaccount.core.Amount.amountOf;

public class ConsolePrinter implements Printer {
    private Console console;

    private static final String SEPARATOR = " | ";
    private static final String HEADER = "Date | AMOUNT | BALANCE";
    private DecimalFormat decimalFormat = new DecimalFormat("##.00");

    public ConsolePrinter(Console console) {

        this.console = console;
    }

    @Override
    public void print(List<StatementLine> statementLines) {
        console.printLine(HEADER);
        printStatements(statementLines);
    }

    private void printStatements(List<StatementLine> statementLines) {
        statementLines.stream()
                .map(statementLine -> formatStatementLine(statementLine)).
                collect(Collectors.toCollection(LinkedList::new)).descendingIterator()
                .forEachRemaining(console::printLine);

    }

    private String formatStatementLine(StatementLine statementLine) {
        StringBuilder statementBuilder = new StringBuilder();
        statementBuilder.append(statementLine.date())
                .append(SEPARATOR)
                .append(format(statementLine.amount()))
                .append(SEPARATOR)
                .append(format(statementLine.balance()));
        return statementBuilder.toString();
    }


    private String format(Amount amount) {

        return amount.format(decimalFormat);

    }





}
