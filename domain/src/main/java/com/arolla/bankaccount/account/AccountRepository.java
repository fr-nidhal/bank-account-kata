package com.arolla.bankaccount.account;

import java.util.List;

public interface AccountRepository {

    Account save(Account account);

    Account findAccountByID(AccountID accountID);

    List<Operation> allOperations(AccountID account);

    void addOperation(AccountID account, Operation operation);

}
