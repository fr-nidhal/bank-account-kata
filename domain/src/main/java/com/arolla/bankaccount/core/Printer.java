package com.arolla.bankaccount.core;

import java.util.List;

public interface Printer {
    void print(List<StatementLine> statementLines);
}
