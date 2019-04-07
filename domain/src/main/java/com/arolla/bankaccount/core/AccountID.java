package com.arolla.bankaccount.core;

import java.util.Objects;

public class AccountID {
    private String code;

    public AccountID(String code) {

        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountID accountID = (AccountID) o;
        return Objects.equals(code, accountID.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
