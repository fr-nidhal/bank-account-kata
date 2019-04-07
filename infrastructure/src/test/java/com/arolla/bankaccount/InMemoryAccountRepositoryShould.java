package com.arolla.bankaccount;

import com.arolla.bankaccount.core.Account;
import com.arolla.bankaccount.core.AccountID;
import com.arolla.bankaccount.core.Amount;
import com.arolla.bankaccount.core.Operation;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;


public class InMemoryAccountRepositoryShould {


    private AccountID accountID;
    private Account account;
    private InMemoryAccountRepository inMemoryAccountRepository;

    @Before
    public void initialize(){
        accountID = new AccountID("0001");
        account =  new Account(accountID,"Nidhal");
        inMemoryAccountRepository = new InMemoryAccountRepository();
    }

    @Test
    public void synchronize_an_account(){
        //when
        inMemoryAccountRepository.synchronize(account);
        //then
        assertThat(inMemoryAccountRepository.findByID(accountID)).isEqualTo(account);

    }
    @Test
    public void find_an_account_by_id(){
        //given
        inMemoryAccountRepository.synchronize(account);
        //when
        Account fromRepository = inMemoryAccountRepository.findByID(accountID);

        //then
        assertThat(fromRepository).isEqualTo(account);
    }



    @Test
    public void add_operation_to_a_given_account(){
        Operation operation = new Operation("07/04/2019", Amount.amountOf(300));

        inMemoryAccountRepository.synchronize(account);

        inMemoryAccountRepository.addOperation(accountID,operation);

        assertThat(inMemoryAccountRepository.allOperations(accountID).contains(operation));
        assertThat(inMemoryAccountRepository.allOperations(accountID).size()).isEqualTo(1);
    }

}