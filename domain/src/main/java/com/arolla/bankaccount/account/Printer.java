package com.arolla.bankaccount.account;

import com.arolla.bankaccount.statement.StatementLine;

import java.util.List;

public interface Printer {
    void print(List<StatementLine> statementLines);
}
