package feature;

import com.arolla.bankaccount.Console;
import com.arolla.bankaccount.ConsolePrinter;
import com.arolla.bankaccount.DateHandler;
import com.arolla.bankaccount.InMemoryAccountRepository;
import com.arolla.bankaccount.core.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.arolla.bankaccount.core.Amount.amountOf;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class AcceptanceTest {


    @Mock Console console;
    @Mock DateHandler dateHandler;


    private AccountService accountService;
    private AccountID accountID;
    private  Account account;


    private AccountRepository accountRepository;
    private Printer printer;


    @Before
    public void initialize(){
        accountID = new AccountID("001");
        account = new Account(accountID,"Nidhal");
        accountRepository = new InMemoryAccountRepository();
        printer = new ConsolePrinter(console);
        StatementLinesService statementLinesService = new StatementLinesService();
        StatementsPrinter statementsPrinter = new StatementsPrinter(statementLinesService,printer);

        accountService = new AccountService(accountRepository, statementsPrinter, dateHandler);

    }

    @Test
    public void print_statements_should_contain_all_my_operations(){

        given(dateHandler.today()).willReturn("10/02/2019","26/03/2019","26/04/2019");


        accountRepository.synchronize(account);

        accountService.deposit(accountID, amountOf(300));
        accountService.deposit(accountID, amountOf(400));
        accountService.withdraw(accountID, amountOf(500));

        accountService.printStatements(accountID);


        //then
        InOrder inOrder = inOrder(console);

        inOrder.verify(console).printLine("Date | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("26/04/2019 | -500,00 | 200,00");
        inOrder.verify(console).printLine("26/03/2019 | 400,00 | 700,00");
        inOrder.verify(console).printLine("10/02/2019 | 300,00 | 300,00");

    }
}
