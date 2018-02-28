package isahasa.fleet;

public class CargoShip implements Ship, CanCarryGoods {
 private CanCarryGoods canCarryGoods;

    public CargoShip(int canCarryGoods) {
      this.canCarryGoods=new CanCarryGoodsBehaviour(canCarryGoods);
    }

    @Override
    public int loadCargo(int cargoWeight) {
        return canCarryGoods.loadCargo(cargoWeight);
    }

    @Override
    public int getCargoWeight() {
        return canCarryGoods.getCargoWeight();
    }
}
