package inheritancemethods.bankaccount;

public class CreditAccount extends DebitAccount {
    private long overdraftLimit;

    public long getOverdraftLimit() {
        return overdraftLimit;
    }

    public CreditAccount(String accountNumber, long balance, long overdraftLimit){
        super(accountNumber,balance);
        this.overdraftLimit=overdraftLimit;
    }

    @Override
    public boolean transaction(long amount) {
        if (getBalance() >= amount + costOfTransaction(amount)) {
            return super.transaction(amount);
        }
        if (getBalance() + overdraftLimit >= amount + costOfTransaction(amount)) {
            overdraftLimit -= (amount + costOfTransaction(amount) - getBalance());
            balanceToZero();
            return true;
        }
        return false;


    }


}

