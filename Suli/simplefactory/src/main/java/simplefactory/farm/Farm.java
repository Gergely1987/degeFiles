package simplefactory.farm;

import java.util.ArrayList;
import java.util.List;

public class Farm {
    private AnimalFactory animalFactory;
    private List<Animal> animals=new ArrayList<>();

    public Farm(AnimalFactory animalFactory) {
        this.animalFactory = animalFactory;
    }

    public void newAnimalArrived(String animalType){
       FarmAnimalFactory farmAnimalFactory=new FarmAnimalFactory();
       animals.add(farmAnimalFactory.create(animalType));
    }

    public List<String> getAnimalVoices(){
        List<String>voices=new ArrayList<>();

        for (Animal ani:animals) {
            voices.add(ani.speak());
        }
return voices;
    }
}
