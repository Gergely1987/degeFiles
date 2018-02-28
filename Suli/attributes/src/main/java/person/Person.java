package person;

public class Person {
    private String name;
    private String identificationCard;
    private Adress adress;


    public void moveTo(String country, String city, String streetAndNumber, String zipCode){
        this.adress=new Adress(country,city,streetAndNumber,zipCode);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", identificationCard='" + identificationCard + '\'' +
                '}'+adress;
    }

    public Person(String name, String identificationCard) {
        this.name = name;
        this.identificationCard = identificationCard;
    }

    public String getName() {
        return name;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdentificationCard(String identificationCard) {
        this.identificationCard = identificationCard;
    }

    public static void main(String[] args) {
        Person p1=new Person("Geri", "888821BA");
        p1.moveTo("Hungary", "fehervar", "szedreskerti lakonegyed 20", "8000");
        System.out.println(p1);
    }
}
