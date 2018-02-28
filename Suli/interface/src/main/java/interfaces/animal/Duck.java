package interfaces.animal;

public class Duck implements Animal {

    //private int numberofLegs;
    //private String name;

    @Override
    public int getNumberOfLegs() {
        return 2;
    }

    @Override
    public String getName() {
        return "Duck";
    }
}
