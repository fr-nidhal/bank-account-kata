package com.arolla.bankaccount;

import com.arolla.bankaccount.core.*;

import static com.arolla.bankaccount.core.Amount.amountOf;

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


        accountRepository.synchronize(account);


        accountService.deposit(accountID, amountOf(300));
        accountService.withdraw(accountID,amountOf(400));
        accountService.deposit(accountID,amountOf(600));

        accountService.printStatements(accountID);


    }
}
