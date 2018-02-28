package methodoverloading.pub;

import java.util.ArrayList;
import java.util.List;

public class ListOfGoodPubs {
    private List<Pub>goodPubs=new ArrayList<>();

    public ListOfGoodPubs(List<Pub> goodPubs) {
        if(goodPubs.isEmpty()){
            throw new IllegalArgumentException("Pub list is empty!");
        }
        this.goodPubs = goodPubs;
    }


    public Pub findTheBest(){
        Pub bestPub=goodPubs.get(0);

        for (int i = 0; i <goodPubs.size() ; i++) {
            if(goodPubs.get(i).getHours()<bestPub.getHours()){
                bestPub=goodPubs.get(i);
            }
            if(goodPubs.get(i).getHours()==bestPub.getHours()){
                if(goodPubs.get(i).getMinutes()<bestPub.getMinutes()){
                    bestPub=goodPubs.get(i);
                }
            }
        }
        return bestPub;
    }
}
