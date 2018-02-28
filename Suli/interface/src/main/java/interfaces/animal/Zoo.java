package interfaces.animal;

import java.util.ArrayList;
import java.util.List;

public class Zoo implements Animal{
    private List<Animal> animals=new ArrayList<>();

    public Zoo(List<Animal> animals) {
        this.animals = animals;
    }

    public int getNumberOfAnimals(){
       return animals.size();
   }



    @Override
    public int getNumberOfLegs() {
      int numberLegs=0;
        for (int i = 0; i <animals.size() ; i++) {
            numberLegs+=animals.get(i).getNumberOfLegs();
        }

        return numberLegs;
    }

    @Override
    public String getName() {
        return null;
    }
}
