package com.arolla.bankaccount.core;


import java.util.List;

public class StatementsPrinter {


      private StatementLinesService statementLinesService;
      private Printer printer;

      public StatementsPrinter(StatementLinesService statementLinesService, Printer printer) {

            this.statementLinesService = statementLinesService;
            this.printer = printer;
      }

      public void printStatementsFrom(List<Operation> allOperations) {
            printer.print(statementLinesService.computeStatementLines(allOperations));
      }
}
