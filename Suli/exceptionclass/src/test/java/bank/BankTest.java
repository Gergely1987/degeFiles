package bank;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class BankTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private double initialBalance;
    private List<Account> accounts;
    private Bank bank;

    @Before
    public void createAccountList() {
        initialBalance = 100;
        accounts = new ArrayList<>();
        accounts.add(new Account("acc1", initialBalance));
        accounts.add(new Account("acc2", initialBalance));
        accounts.add(new Account("acc3", initialBalance));
        accounts.add(new Account("acc4", initialBalance));

        bank = new Bank(accounts);
    }

    @Test
    public void constructorNullParamShouldThrowException() {
        exception.expect(IllegalArgumentException.class);

        new Bank(null);
    }

    @Test
    public void paymentUnknownAccountNumberShouldThrowException() {
        String accountNumber = "unknownaccountNumber";

        exception.expect(InvalidBankOperationException.class);
        exception.expect(hasProperty("errorCode", is(InvalidBankOperationException.ErrorCode.INVALID_ACCOUNTNUMBER)));

        bank.payment(accountNumber, 10);
    }

    @Test
    public void paymentShouldSubtractBalance() {
        String accountNumber = "acc2";
        double amount = 10;

        bank.payment(accountNumber, amount);
        for (int j = 0; j < accounts.size(); j++) {
            Account account = accounts.get(j);
            if (account.getAccountNumber().equals(accountNumber)) {
                assertThat(account.getBalance(), equalTo(initialBalance - amount));
            }
            else {
                assertThat(account.getBalance(), equalTo(initialBalance));
            }
        }
    }

    @Test
    public void depositUnknownAccountNumberShouldThowException() {
        String accountNumber = "unknownaccountNumber";

        exception.expect(InvalidBankOperationException.class);
        exception.expect(hasProperty("errorCode", is(InvalidBankOperationException.ErrorCode.INVALID_ACCOUNTNUMBER)));

        bank.deposit(accountNumber, 10);
    }

    @Test
    public void depositShouldModifyBalance() {
        String accountNumber = "acc2";
        double amount = 10;

        bank.deposit(accountNumber, amount);
        for (int j = 0; j < accounts.size(); j++) {
            Account account = accounts.get(j);
            if (account.getAccountNumber().equals(accountNumber)) {
                assertThat(account.getBalance(), equalTo(initialBalance + amount));
            }
            else {
                assertThat(account.getBalance(), equalTo(initialBalance));
            }
        }
    }

}