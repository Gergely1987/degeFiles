package bankaccounts;

public class Transaction {
    private String accountNumber;
    private TransactionType transactionType;
    private int amount;

    private boolean debit=false;
    private boolean credit=false;

    public String getAccountNumber() {
        return accountNumber;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isDebit() {
        if(transactionType.equals(TransactionType.DEBIT)){
            debit=true;
        }
        return debit;
    }

    public boolean isCredit() {
        if(transactionType.equals(TransactionType.CREDIT)){
            credit=true;
        }
        return credit;
    }

    public Transaction(String accountNumber, TransactionType transactionType, int amunt) {
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amunt;
    }
}
