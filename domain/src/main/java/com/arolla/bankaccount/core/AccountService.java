package com.arolla.bankaccount.core;

import com.arolla.bankaccount.DateHandler;

public class AccountService {


    private AccountRepository accountRepository;
    private StatementsPrinter statementsPrinter;
    private DateHandler dateHandler;

    public AccountService(AccountRepository accountRepository, StatementsPrinter statementsPrinter, DateHandler dateHandler) {

        this.accountRepository = accountRepository;
        this.statementsPrinter = statementsPrinter;
        this.dateHandler = dateHandler;
    }

    public void deposit(AccountID accountID, Amount amount) {
        accountRepository.addOperation(accountID,new Operation(dateHandler.today(),amount));
    }

    public void withdraw(AccountID accountID, Amount amount) {
        accountRepository.addOperation(accountID,new Operation(dateHandler.today(),amount.negative()));
    }

    public void printStatements(AccountID accountID) {
        statementsPrinter.printStatementsFrom(accountRepository.allOperations(accountID));
    }
}
