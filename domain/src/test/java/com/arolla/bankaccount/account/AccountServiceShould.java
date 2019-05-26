package com.arolla.bankaccount.account;

import com.arolla.bankaccount.DateHandler;
import com.arolla.bankaccount.statement.StatementsPrinter;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.arolla.bankaccount.account.OperationType.DEPOSIT;
import static com.arolla.bankaccount.account.OperationType.WITHDRAW;
import static com.arolla.bankaccount.amount.Amount.amountOf;
import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("The Account Service Should")
public class AccountServiceShould {
    private static final String TODAY = "04/04/2019";
    private AccountService accountService;

    @Mock
    AccountID accountID;
    @Mock
    AccountRepository accountRepository;
    @Mock
    StatementsPrinter statementsPrinter;
    @Mock
    DateHandler dateHandler;

    @BeforeEach
    void initialize() {
        accountService = new AccountService(accountRepository, statementsPrinter, dateHandler);
    }


    @Test
    void store_a_deposit_operation_into_my_account() {

        given(dateHandler.today()).willReturn(TODAY);
        //when
        accountService.deposit(accountID, amountOf(300));
        //then
        verify(accountRepository).addOperation(accountID, new Operation(TODAY, amountOf(300), DEPOSIT));

    }

    @Test
    void store_a_withdraw_operation_into_my_account() {

        given(dateHandler.today()).willReturn(TODAY);
        //when
        accountService.withdraw(accountID, amountOf(300));
        //then
        verify(accountRepository).addOperation(accountID, new Operation(TODAY, amountOf(300), WITHDRAW));

    }

    @Test
    void print_all_my_account_statements() {

        List<Operation> operations = asList(new Operation(TODAY, amountOf(300), DEPOSIT));
        given(accountRepository.allOperations(accountID)).willReturn(operations);


        accountService.printStatements(accountID);

        verify(statementsPrinter).printStatementsFrom(accountRepository.allOperations(accountID));

    }

}