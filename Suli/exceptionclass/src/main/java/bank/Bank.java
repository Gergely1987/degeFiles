package bank;

import java.util.List;

public class Bank {
    private double initialBalance;
    private List<Account> accounts;
    private Bank bank;

    public Bank(List<Account> accounts) {
        if(accounts==null){
            throw new IllegalArgumentException();
        }
        this.accounts = accounts;
    }

    public void payment(String accountNumber, double amount){
        for (Account acc:accounts) {
            if(acc.getAccountNumber().equals(accountNumber)){
                acc.subtract(amount);
                return;
            }


        }
        throw new InvalidBankOperationException(InvalidBankOperationException.ErrorCode.INVALID_ACCOUNTNUMBER);
    }

    public void deposit(String accountNumber, double amount){
        for (Account acc:accounts) {
            if(!acc.getAccountNumber().equals(accountNumber)){
                throw new InvalidBankOperationException(InvalidBankOperationException.ErrorCode.INVALID_ACCOUNTNUMBER);
            } else{
                acc.deposit(amount);
            }
        }

    }
}
