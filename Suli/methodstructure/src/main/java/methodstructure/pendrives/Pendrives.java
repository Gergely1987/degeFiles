package methodstructure.pendrives;

import java.util.List;

public class Pendrives {

    public Pendrive best(List<Pendrive> pend) {
        Pendrive bestPendrive = pend.get(0);

        for (int i = 0; i < pend.size(); i++) {
            if (bestPendrive.comparePricePerCapacity(pend.get(i)) == 1) {
                bestPendrive = pend.get(i);
            }
        }

        return bestPendrive;
    }

    public Pendrive cheapest(List<Pendrive> pend) {
        Pendrive cheapest = pend.get(0);

        for (int i = 0; i < pend.size(); i++) {
            if (pend.get(i).cheaperThan(cheapest)) {
                cheapest = pend.get(i);
            }
        }
        return cheapest;
    }

    public  void risePriceWhereCapacity(List<Pendrive>pend, int percent, int capacity){

        for (int i = 0; i <pend.size() ; i++) {
            if(pend.get(i).getCapacity()==capacity){
                pend.get(i).risePrice(percent);
            }
        }

    }

}
