package com.arolla.bankaccount.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {
    private final AccountID accountID;
    private final String name;
    private List<Operation> operations = new ArrayList<>();

    public Account(AccountID accountID, String name) {
        this.accountID = accountID;
        this.name = name;
    }

    public AccountID getID() {
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
