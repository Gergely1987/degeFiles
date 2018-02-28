package introinheritance.employee;

public class Employee extends Person {
private double salary;

    public Employee() {
    }

    public Employee(String name, String address, double salary) {
        super(name, address);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(int percent){
        this.salary=salary*(100+percent)/100;
    }
}
