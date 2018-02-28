package algorithmsdecision;

import java.util.ArrayList;
import java.util.List;

public class BankAccountDecisionMaker {


   public boolean containsBalanceGreaterThan(List<BankAccount> total, int limit){
      boolean isExist=false;
       List<BankAccount> limitedAccounts=new ArrayList<>();

       for (int i = 0; i <total.size() ; i++) {
           if(total.get(i).getBalance()>limit){
               limitedAccounts.add(total.get(i));
           }
       }
       if(limitedAccounts.size()>0){
           isExist=true;
       }
       return isExist;
   }

}
