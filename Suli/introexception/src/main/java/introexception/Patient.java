package introexception;

public class Patient {

    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;



    public Patient(String name, String socialSecurityNumber, int yearOfBirth) {

        if(new SsnValidator().isValidSsn(socialSecurityNumber)==false){
            throw new IllegalArgumentException("Not valid socialSecurityNumber: " + socialSecurityNumber);
        }
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.yearOfBirth = yearOfBirth;

    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

}
