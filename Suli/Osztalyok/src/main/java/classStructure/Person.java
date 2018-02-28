package classStructure;

import java.util.Date;

public class Person {
    private String name;
    private Date dob;
    private String birthName;

    public Person(String name, Date dob, String birthName) {
        this.name = name;
        this.dob = dob;
        this.birthName = birthName;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public String getBirthName() {
        return birthName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
            int i=10;
        System.out.println(!(i%2==0));
        System.out.println(i%2==0 ? "páros":"páratlan");
    }
}
