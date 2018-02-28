package inheritanceconstructor.cars;

public class Jeep extends Car {
    private double extraCapacity;
    private double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        if (fuel + extraFuel > tankCapacity + extraCapacity) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    public boolean isEnoughPetrol(int km) {
        if (km / 100 * super.getFuelRate() > super.getFuel() + this.extraFuel) {
            return false;
        }
        return true;
    }



    public void drive(int km) {
        if (!isEnoughPetrol(km)) {
            throw new RuntimeException("Not enough fuel available!");
        }
        if (km * getFuelRate() / 100 > extraFuel) {
            super.drive((int) (km - extraFuel / getFuelRate() * 100));
            extraFuel = 0;
        } else {
            extraFuel -= km * getFuelRate() / 100;
        }


    }

    public double calculateRefillAmount() {
        return super.getTankCapacity() + this.extraCapacity - super.getFuel() - this.extraFuel;

    }

    public double getExtraCapacity() {
        return extraCapacity;
    }

    public double getExtraFuel() {
        return extraFuel;
    }
}
