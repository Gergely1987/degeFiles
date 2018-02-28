package introinheritance.employee;

public class Boss extends Employee{
    private int numberOfEmployees;
    private final double LEADERSHIP_FACTOR = 0.1;

    public Boss(String name, String address, double salary, int numberOfEmployees) {
        super(name, address, salary);
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public double getSalary() {
        return super.getSalary()+ (super.getSalary() * numberOfEmployees * LEADERSHIP_FACTOR);
    }

    public Boss(){

    }
}
