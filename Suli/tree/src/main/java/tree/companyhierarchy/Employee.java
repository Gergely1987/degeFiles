package tree.companyhierarchy;

public class Employee implements Comparable<Employee> {
    private String email;
    private String name;
    private String bossEmail;

    public String getBossEmail() {
        return bossEmail;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Employee(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public Employee(String email, String name, String bossEmail) {
        this.email = email;
        this.name = name;
        this.bossEmail = bossEmail;
    }

    @Override
    public int compareTo(Employee o) {
        return email.compareTo(o.email);
    }


}
