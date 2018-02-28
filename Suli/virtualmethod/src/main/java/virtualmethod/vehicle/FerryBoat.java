package virtualmethod.vehicle;

public class FerryBoat extends Vehicle {
     static int MAX_CARRY_WEIGHT=2000;
     private Car car;


    public boolean canCarry(Vehicle vehicle){
        if(vehicle.getVehicleWeight()<MAX_CARRY_WEIGHT){
            return true;
        }
        return false;
    }

    public FerryBoat(int vehicleWeight) {
        super(vehicleWeight);
    }


    public boolean load(Car car){
        if(canCarry(car)){
            this.car=car;
            return true;
        }
        return false;
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() + car.getGrossLoad();
    }

    @Override
    public String toString(){
       if(car instanceof Van){
           return...
       }
       return...
    }
}
