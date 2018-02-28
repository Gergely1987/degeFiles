package dpintro.reptile;

public abstract class LandDweller {
    private int energy;

    public LandDweller(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    protected void decreaseEnergy(int value){
        energy-=value;
    }

}
