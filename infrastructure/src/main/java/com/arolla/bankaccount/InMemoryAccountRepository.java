package com.arolla.bankaccount;

import com.arolla.bankaccount.core.Account;
import com.arolla.bankaccount.core.AccountID;
import com.arolla.bankaccount.core.AccountRepository;
import com.arolla.bankaccount.core.Operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryAccountRepository implements AccountRepository {


    private Map<AccountID, Account> accounts = new HashMap<>();

    @Override
    public List<Operation> allOperations(AccountID accountID) {
       return findByID(accountID).getOperations();
    }

    @Override
    public void addOperation(AccountID accountID, Operation operation) {
        allOperations(accountID).add(operation);
    }
    @Override
    public Account synchronize(Account account) {
        return accounts.putIfAbsent(account.getID(),account);
    }
    @Override
    public Account findByID(AccountID accountID) {
        return accounts.getOrDefault(accountID,new Account(accountID,"empty"));
    }
}
