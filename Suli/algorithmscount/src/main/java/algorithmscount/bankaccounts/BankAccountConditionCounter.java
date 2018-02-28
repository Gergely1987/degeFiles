package bankaccounts;

import java.util.List;

public class BankAccountConditionCounter {

   public int countWithBalanceGreaterThan(List<BankAccount> total, int limit){
        int count=0;

       for (int i = 0; i <total.size() ; i++) {
           if(total.get(i).getBalance()>limit){
               count++;
           }
       }

        return count;

   }
}
