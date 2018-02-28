package methodstructure.bmi;

public class BodyMass {
    private double weight;
    private double height;



    public BodyMass(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double bodyMassIndex(){
        return weight/(height*height);
  }

    public BmiCategory body(){
        if (bodyMassIndex() < 18.50) {
            return BmiCategory.UNDERWEIGHT;
        }
        else if(bodyMassIndex()>25){
            return BmiCategory.OVERWEIGHT;
        }
        return BmiCategory.NORMAL;

    }

    public boolean isThinnerThan (BodyMass bm){
        if(bm.bodyMassIndex()>bodyMassIndex()){
            return true;
        }
        return false;
    }


}
