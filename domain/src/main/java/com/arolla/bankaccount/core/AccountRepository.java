package com.arolla.bankaccount.core;

import java.util.List;

public interface AccountRepository {


     List<Operation> allOperations(AccountID account) ;

     void addOperation(AccountID account, Operation operation);

     Account synchronize(Account account);

     Account findByID(AccountID accountID);
}
