package isahasa.fleet;

public class FerryBoat implements Ship, CanCarryGoods, CanCarryPassengers {
        private CanCarryGoods canCarryGoods;
        private CanCarryPassengers canCarryPassengers;

        public FerryBoat(int canCarryGoods, int canCarryPassengers){
            this.canCarryGoods=new CanCarryGoodsBehaviour(canCarryGoods);
            this.canCarryPassengers=new CanCarryPassengersBehaviour(canCarryPassengers);
        }

    @Override
    public int loadCargo(int cargoWeight) {
        return canCarryGoods.loadCargo(cargoWeight);
    }

    @Override
    public int getCargoWeight() {
        return canCarryGoods.getCargoWeight();
    }

    @Override
    public int loadPassenger(int passengers) {
        return canCarryPassengers.loadPassenger(passengers);
    }

    @Override
    public int getPassengers() {
        return canCarryPassengers.getPassengers();
    }
}
