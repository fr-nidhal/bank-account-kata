package com.arolla.bankaccount;

import com.arolla.bankaccount.account.Account;
import com.arolla.bankaccount.account.AccountID;
import com.arolla.bankaccount.account.AccountRepository;
import com.arolla.bankaccount.account.Operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryAccountRepository implements AccountRepository {


    private Map<AccountID, Account> accounts = new HashMap<>();

    @Override
    public List<Operation> allOperations(AccountID accountID) {
       return findAccountByID(accountID).getOperations();
    }

    @Override
    public void addOperation(AccountID accountID, Operation operation) {
        allOperations(accountID).add(operation);
    }
    @Override
    public Account save(Account account) {
        return accounts.putIfAbsent(account.getAccountID(),account);
    }
    @Override
    public Account findAccountByID(AccountID accountID) {
        return accounts.getOrDefault(accountID,new Account(accountID,"empty"));
    }
}
