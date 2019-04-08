package com.arolla.bankaccount;

import com.arolla.bankaccount.account.*;
import com.arolla.bankaccount.statement.StatementLinesService;
import com.arolla.bankaccount.statement.StatementsPrinter;

import static com.arolla.bankaccount.amount.Amount.amountOf;

public class BankAccountRunner {


    public static void main(String[] args) {

        AccountID accountID = new AccountID("001");
        Account account = new Account(accountID,"Nidhal");

        AccountRepository accountRepository = new InMemoryAccountRepository();
        StatementLinesService statementLineService = new StatementLinesService();
        Console console = new Console();
        Printer printer = new ConsolePrinter(console);
        StatementsPrinter statementsPrinter = new StatementsPrinter(statementLineService,printer);
        DateHandler dateHandler = new DateHandler();
        AccountService accountService = new AccountService(accountRepository,statementsPrinter,dateHandler);


        accountRepository.save(account);


        accountService.deposit(accountID, amountOf(300));
        accountService.withdraw(accountID,amountOf(400));
        accountService.deposit(accountID,amountOf(600));

        accountService.printStatements(accountID);


    }
}
