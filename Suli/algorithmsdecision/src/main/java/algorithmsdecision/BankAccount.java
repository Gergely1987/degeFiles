package algorithmsdecision;

public class BankAccount {
    private String nameOfOwner;
    private String accountNumber;
    private int balance;

    public int withdraw(int cash){
        return balance-cash;
    }

    public int deposit(int cash){
        return balance+cash;
    }

    public BankAccount(String nameOfOwner, String accountNumber, int balance) {
        this.nameOfOwner = nameOfOwner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }
}
