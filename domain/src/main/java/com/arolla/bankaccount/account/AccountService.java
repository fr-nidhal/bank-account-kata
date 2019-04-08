package com.arolla.bankaccount.account;

import com.arolla.bankaccount.DateHandler;
import com.arolla.bankaccount.amount.Amount;
import com.arolla.bankaccount.statement.StatementsPrinter;

import static com.arolla.bankaccount.account.OperationType.DEPOSIT;
import static com.arolla.bankaccount.account.OperationType.WITHDRAW;

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
        accountRepository.addOperation(accountID,new Operation(dateHandler.today(),amount, DEPOSIT));
    }

    public void withdraw(AccountID accountID, Amount amount) {
        accountRepository.addOperation(accountID,new Operation(dateHandler.today(),amount, WITHDRAW));
    }

    public void printStatements(AccountID accountID) {
        statementsPrinter.printStatementsFrom(accountRepository.allOperations(accountID));
    }
}
