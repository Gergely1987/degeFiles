package transactions;

import java.util.ArrayList;
import java.util.List;

public class TransactionSumCalculator {

    public int sumAmountOfCreditEntries(List<Transaction> transactions) {
        int sumCredit = 0;

        for (int i = 0; i <transactions.size() ; i++) {
            if(transactions.get(i).isCredit()){
                sumCredit+=transactions.get(i).getAmount();
            }
        }

        return sumCredit;
    }
}
