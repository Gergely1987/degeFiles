package sample;

import javafx.beans.property.SimpleStringProperty;

public class EmployeePassword {
   private SimpleStringProperty id;
   private SimpleStringProperty password;

    public EmployeePassword(String id, String password) {
        this.id = new SimpleStringProperty(id);
        this.password =  new SimpleStringProperty(password);
    }

    public SimpleStringProperty getId() {
        return id;
    }

    public void setId(SimpleStringProperty id) {
        this.id = id;
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
}
