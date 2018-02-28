package transactions;

import org.omg.CORBA.TRANSACTION_MODE;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private String accountNumber;
    private TransactionOperation tO;
    private int amount;

    private boolean credit = false;
    private boolean debit = false;


    public boolean isCredit() {
        if (tO.equals(TransactionOperation.CREDIT)) {
            credit = true;
        }
        return credit;
    }

    public boolean isDebit() {
        if (tO.equals(TransactionOperation.DEBIT)) {
            debit = true;
        }
        return debit;
    }

    public Transaction(String accountNumber, TransactionOperation tO, int amount) {
        this.accountNumber = accountNumber;
        this.tO = tO;
        this.amount = amount;
    }

    public Transaction() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public TransactionOperation gettO() {
        return tO;
    }

    public int getAmount() {
        return amount;
    }
}
