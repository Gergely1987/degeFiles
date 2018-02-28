package dpintro.reptile;

public class Crocodile extends LandDweller implements CanSwim{


    public Crocodile(int energy) {
        super(energy);
    }

    @Override
    public void swim() {
        if(getEnergy()<5){
            throw new IllegalArgumentException("Not enough energy to move!");
        }
        decreaseEnergy(5);
    }

    public void walk(){
        if(getEnergy()<20){
            throw new IllegalArgumentException("Not enough energy to move!");
        }
        decreaseEnergy(20);
    }
}
