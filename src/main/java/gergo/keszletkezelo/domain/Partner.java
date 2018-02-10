package gergo.keszletkezelo.domain;
import javafx.beans.property.SimpleStringProperty;

public class Partner {
    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty taxNumber;
    private final SimpleStringProperty areaCode;
    private final SimpleStringProperty city;
    private final SimpleStringProperty street;
    private final SimpleStringProperty streetNum;
    private final SimpleStringProperty contact;
    private final SimpleStringProperty email;
    private final SimpleStringProperty phoneNumber;
    private final SimpleStringProperty discountPercent;



    public String getDiscountPercent() {
        return discountPercent.get();
    }

    public SimpleStringProperty discountPercentProperty() {
        return discountPercent;
    }

    public void setDiscountPercent(String discountPercent) {
        this.discountPercent.set(discountPercent);
    }



    public Partner(int id, String name, String taxNumber, String contact, String areaCode, String city, String street, String streetNum, String phoneNumber, String email){

        this.name=new SimpleStringProperty("");
        this.taxNumber=new SimpleStringProperty("");
        this.areaCode=new SimpleStringProperty("");
        this.city=new SimpleStringProperty("");
        this.street=new SimpleStringProperty("");
        this.streetNum=new SimpleStringProperty("");
        this.contact=new SimpleStringProperty("");
        this.email=new SimpleStringProperty("");
        this.phoneNumber =new SimpleStringProperty("");
        this.discountPercent=new SimpleStringProperty("");
        this.id=new SimpleStringProperty("");
    }

    public Partner(String name, String taxNumber,String contact, String areaCode, String city, String street, String streetNum, String phoneNumber,  String email, String discountPercent){

        this.name=new SimpleStringProperty(name);
        this.taxNumber=new SimpleStringProperty(taxNumber);
        this.areaCode=new SimpleStringProperty(areaCode);
        this.city=new SimpleStringProperty(city);
        this.street=new SimpleStringProperty(street);
        this.streetNum=new SimpleStringProperty(streetNum);
        this.contact=new SimpleStringProperty(contact);
        this.email=new SimpleStringProperty(email);
        this.phoneNumber =new SimpleStringProperty(phoneNumber);
        this.discountPercent=new SimpleStringProperty(discountPercent);
        this.id=new SimpleStringProperty("");
    }

    public Partner(Integer id, String name, String taxNumber, String contact, String areaCode, String city, String street, String streetNum, String phoneNumber, String email, String discountPercent){

        this.name=new SimpleStringProperty(name);
        this.taxNumber=new SimpleStringProperty(taxNumber);
        this.areaCode=new SimpleStringProperty(areaCode);
        this.city=new SimpleStringProperty(city);
        this.street=new SimpleStringProperty(street);
        this.streetNum=new SimpleStringProperty(streetNum);
        this.contact=new SimpleStringProperty(contact);
        this.email=new SimpleStringProperty(email);
        this.phoneNumber =new SimpleStringProperty(phoneNumber);
        this.discountPercent=new SimpleStringProperty(discountPercent);
        this.id=new SimpleStringProperty(String.valueOf(id));
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getTaxNumber() {
        return taxNumber.get();
    }

    public SimpleStringProperty taxNumberProperty() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber.set(taxNumber);
    }

    public String getAreaCode() {
        return areaCode.get();
    }

    public SimpleStringProperty areaCodeProperty() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode.set(areaCode);
    }

    public String getCity() {
        return city.get();
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getStreet() {
        return street.get();
    }

    public SimpleStringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public String getStreetNum() {
        return streetNum.get();
    }

    public SimpleStringProperty streetNumProperty() {
        return streetNum;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum.set(streetNum);
    }

    public String getContact() {
        return contact.get();
    }

    public SimpleStringProperty contactProperty() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact.set(contact);
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

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public SimpleStringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }
}
