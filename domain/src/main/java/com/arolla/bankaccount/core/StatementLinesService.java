package com.arolla.bankaccount.core;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static com.arolla.bankaccount.core.Amount.amountOf;

public class StatementLinesService {
    public List<StatementLine> computeStatementLines(List<Operation> operations) {

        BalanceHolder balanceHolder = new BalanceHolder(amountOf(0));
        return operations.stream()
                .map(operation -> statementLineOf(operation,balanceHolder))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private StatementLine statementLineOf(Operation operation, BalanceHolder holder) {

        return new StatementLine(operation.date(),operation.amount(),holder.incrementAndGet(operation.amount()));
    }

    private class BalanceHolder{

        private Amount amount;

        public BalanceHolder(Amount amount) {

            this.amount = amount;
        }

        Amount incrementAndGet(Amount otherAmount){
            this.amount = amount.plus(otherAmount);
            return this.amount;
        }
    }


}
