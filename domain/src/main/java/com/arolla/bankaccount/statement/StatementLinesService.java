package com.arolla.bankaccount.statement;

import com.arolla.bankaccount.account.Operation;
import com.arolla.bankaccount.amount.AmountHolder;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static com.arolla.bankaccount.amount.Amount.amountOf;

public class StatementLinesService {
    public List<StatementLine> computeStatementLines(List<Operation> operations) {

        AmountHolder balanceHolder = new AmountHolder(amountOf(0));
        return operations.stream()
                .map(operation -> statementLineOf(operation,balanceHolder))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private StatementLine statementLineOf(Operation operation, AmountHolder holder) {

        return new StatementLine(operation.date(),operation.amount(),holder.incrementAndGet(operation.amount()));
    }




}
