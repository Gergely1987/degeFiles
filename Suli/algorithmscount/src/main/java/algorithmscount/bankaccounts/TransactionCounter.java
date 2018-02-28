package bankaccounts;

import java.util.List;

public class TransactionCounter {

   public int countEntryLessThan(List<Transaction> total, int limit){
       int count=0;
       for (int i = 0; i <total.size() ; i++) {
           if(total.get(i).getAmount()<limit){
               count++;
           }
       }
       return count;
   }

}
