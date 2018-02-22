package Phonebook;

import javafx.beans.property.SimpleStringProperty;

public class Person {
//SIMPLESTRINGPROPERTY képes kommunikálni az adattáblával, kompatibils a tableview elemekkel
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty email;
    private final SimpleStringProperty id;

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public Person() {
        this.lastName =  new SimpleStringProperty("");
        this.firstName = new SimpleStringProperty("");
        this.email =  new SimpleStringProperty("");
        this.id=new SimpleStringProperty("");
    }

    public Person(String lastName,String firstName,  String email) {
        this.lastName =  new SimpleStringProperty(lastName);
        this.firstName =  new SimpleStringProperty(firstName);
        this.email =  new SimpleStringProperty(email);
        this.id=new SimpleStringProperty("");
    }

    public Person(Integer id, String lastName,String firstName,  String email) {
        this.lastName =  new SimpleStringProperty(lastName);
        this.firstName =  new SimpleStringProperty(firstName);
        this.email =  new SimpleStringProperty(email);
        this.id=new SimpleStringProperty(String.valueOf(id));
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
}
