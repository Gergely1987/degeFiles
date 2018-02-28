package bank;

public class Account {
    private String accountNumber;
    private double balance;
    private double maxSubtract=100000;

    public Account(String accountNumber, double balance) {
        if(accountNumber==null || accountNumber.isEmpty()){
            throw new IllegalArgumentException("Account number must not be empty!");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double subtract(double amount){
       if(amount>balance){
           throw new InvalidBankOperationException(InvalidBankOperationException.ErrorCode.LOW_BALANCE);
       }
       if(amount>maxSubtract || amount<0){
           throw new InvalidBankOperationException(InvalidBankOperationException.ErrorCode.INVALID_AMOUNT);
       }
       balance-=amount;
       return balance;
    }

    public double deposit (double amount){
        balance+=amount;
        if (amount < 0) {
            throw new InvalidBankOperationException(InvalidBankOperationException.ErrorCode.INVALID_AMOUNT);
        }

        return balance;
    }


    public void setMaxSubtract(double maxSubtract) {
        if (maxSubtract < 0) {
            throw new InvalidBankOperationException(InvalidBankOperationException.ErrorCode.INVALID_AMOUNT);
        }
        this.maxSubtract = maxSubtract;
    }



    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxSubtract() {
        return maxSubtract;
    }
}
