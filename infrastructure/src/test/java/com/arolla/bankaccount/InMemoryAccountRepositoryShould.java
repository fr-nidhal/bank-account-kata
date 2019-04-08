package com.arolla.bankaccount;

import com.arolla.bankaccount.account.Account;
import com.arolla.bankaccount.account.AccountID;
import com.arolla.bankaccount.account.Operation;
import com.arolla.bankaccount.amount.Amount;
import org.junit.Before;
import org.junit.Test;

import static com.arolla.bankaccount.account.OperationType.WITHDRAW;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class InMemoryAccountRepositoryShould {


    private AccountID accountID;
    private Account account;
    private InMemoryAccountRepository inMemoryAccountRepository;

    @Before
    public void initialize() {
        accountID = new AccountID("0001");
        account = new Account(accountID, "Nidhal");
        inMemoryAccountRepository = new InMemoryAccountRepository();
    }

    @Test
    public void synchronize_an_account() {
        //when
        inMemoryAccountRepository.save(account);
        //then
        assertThat(inMemoryAccountRepository.findAccountByID(accountID), is(account));

    }

    @Test
    public void find_an_account_by_id() {
        //given
        inMemoryAccountRepository.save(account);

        //when
        Account fromRepository = inMemoryAccountRepository.findAccountByID(accountID);

        //then
        assertThat(fromRepository, is(account));
    }


    @Test
    public void add_operation_to_a_given_account() {
        //given
        Operation operation = new Operation("07/04/2019", Amount.amountOf(300), WITHDRAW);
        inMemoryAccountRepository.save(account);

        //when
        inMemoryAccountRepository.addOperation(accountID, operation);

        //then
        assertTrue(inMemoryAccountRepository.allOperations(accountID).contains(operation));
        assertThat(inMemoryAccountRepository.allOperations(accountID).size(),is(1));
    }

}