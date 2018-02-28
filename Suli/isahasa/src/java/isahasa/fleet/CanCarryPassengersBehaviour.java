package isahasa.fleet;

public class CanCarryPassengersBehaviour implements CanCarryPassengers{
   private int passangers;
   private int maxPassangers;

    public CanCarryPassengersBehaviour(int maxPassangers) {
        this.maxPassangers = maxPassangers;
    }

    @Override
    public int loadPassenger(int passengers) {
       if(passengers>maxPassangers){
           this.passangers=maxPassangers;
           return passengers-maxPassangers;
       }
        this.passangers=passengers;
        return 0;
    }

    @Override
    public int getPassengers() {
        return passangers;
    }
}
