package inheritanceconstructor.cars;

public class Car {
    private double fuelRate;
    private double fuel;
    private double tankCapacity;

    public Car() {
    }

    public Car(double fuelRate, double fuel, double tankCapacity) {
        if(fuel>tankCapacity){
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.fuelRate = fuelRate;
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }

    public void modifyFuelAmount(double fuel) {
        this.fuel=this.fuel+fuel;
    }

    public void drive(int km) {
        if(km/100*fuelRate>this.fuel){
            throw new RuntimeException("Not enough fuel available!");
        }
        this.fuel=this.fuel-km*fuelRate/100;
    }

    public double calculateRefillAmount() {
        return this.tankCapacity-this.fuel;

    }

    public double getFuelRate() {
        return fuelRate;
    }

    public double getFuel() {
        return fuel;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }
}
