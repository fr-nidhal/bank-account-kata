package com.arolla.bankaccount.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {
    private final AccountID accountID;
    private final String ownerName;
    private List<Operation> operations = new ArrayList<>();

    public Account(AccountID accountID, String ownerName) {
        this.accountID = accountID;
        this.ownerName = ownerName;
    }

    public AccountID getAccountID() {
        return accountID;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountID, account.accountID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountID);
    }
}
