package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {

    private List<Ship> ships = new ArrayList<>();
    private int waitingPersons;
    private int waitingCargo;

    public int getWaitingPersons() {
        return waitingPersons;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void lift(int person, int cargo) {
        waitingPersons = person;
        waitingCargo = cargo;

        for (Ship sh : ships) {

            if (sh instanceof CanCarryGoods && sh instanceof CanCarryPassengers) {
                waitingCargo = ((CanCarryGoods) sh).loadCargo(waitingCargo);
                waitingPersons = ((CanCarryPassengers) sh).loadPassenger(waitingPersons);
            } else if (sh instanceof CanCarryPassengers) {
                waitingPersons = ((CanCarryPassengers) sh).loadPassenger(waitingPersons);
            } else if (sh instanceof CanCarryGoods) {
                waitingCargo = ((CanCarryGoods) sh).loadCargo(waitingCargo);
            }
        }
    }

}
