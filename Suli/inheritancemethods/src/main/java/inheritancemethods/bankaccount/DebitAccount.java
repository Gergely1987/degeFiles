package inheritancemethods.bankaccount;

public class DebitAccount {
     String accountNumber;
     long balance;
     double COST = 3.0;
     static final long MIN_COST = 200;

    public DebitAccount(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public DebitAccount() {
    }

    public final long costOfTransaction(long amount) {
        if (amount * COST / 100 > MIN_COST) {
            return (long) (amount * COST / 100);
        } else return MIN_COST;
    }


    public boolean transaction(long amount) {
        if (balance >= amount + costOfTransaction(amount)) {
            balance -= (amount + costOfTransaction(amount));
            return true;
        }
        return false;
    }


    public void balanceToZero() {
        balance = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }
}
