package sales;

import java.util.ArrayList;
import java.util.List;

public class Salesperson {

    private String name;
    private int amount;

    private List<Salesperson> persons=new ArrayList<>();

    public List<Salesperson> getPersons() {
        return persons;
    }

    public Salesperson(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public Salesperson() {
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}
