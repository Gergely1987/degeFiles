package gergo.keszletkezelo.domain;
import javafx.beans.property.SimpleStringProperty;

public class Employee {
    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty level;
    private final SimpleStringProperty birthDate;
    private final SimpleStringProperty birthPlace;
    private final SimpleStringProperty IDCard;
    private final SimpleStringProperty address;
    private final SimpleStringProperty phoneNumber;
    private final SimpleStringProperty idShop;

    public String getBirthPlace() {
        return birthPlace.get();
    }

    public SimpleStringProperty birthPlaceProperty() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace.set(birthPlace);
    }



public Employee(){
    this.id=new SimpleStringProperty("");
    this.name=new SimpleStringProperty("");
    this.level=new SimpleStringProperty("");
    this.birthDate=new SimpleStringProperty("");
    this.birthPlace=new SimpleStringProperty("");
    this.IDCard=new SimpleStringProperty("");
    this.address =new SimpleStringProperty("");
    this.phoneNumber=new SimpleStringProperty("");
    this.idShop=new SimpleStringProperty("");

    }

    public Employee(String name, String level, String birthDate,String birthPlace, String IDCard, String address, String phoneNumber, String idShop){
        this.id=new SimpleStringProperty("");
        this.name=new SimpleStringProperty(name);
        this.level=new SimpleStringProperty(level);
        this.birthDate=new SimpleStringProperty(birthDate);
        this.birthPlace=new SimpleStringProperty(birthPlace);
        this.IDCard=new SimpleStringProperty(IDCard);
        this.address =new SimpleStringProperty(address);
        this.phoneNumber=new SimpleStringProperty(phoneNumber);
        this.idShop=new SimpleStringProperty(idShop);

    }

    public Employee(Integer id, String name, String level, String birthDate,String birthPlace, String IDCard, String address, String phoneNumber, String idShop){
        this.id=new SimpleStringProperty(String.valueOf(id));
        this.name=new SimpleStringProperty(name);
        this.level=new SimpleStringProperty(level);
        this.birthDate=new SimpleStringProperty(birthDate);
        this.birthPlace=new SimpleStringProperty(birthPlace);
        this.IDCard=new SimpleStringProperty(IDCard);
        this.address =new SimpleStringProperty(address);
        this.phoneNumber=new SimpleStringProperty(phoneNumber);
        this.idShop=new SimpleStringProperty(idShop);

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

    public String getLevel() {
        return level.get();
    }

    public SimpleStringProperty levelProperty() {
        return level;
    }

    public void setLevel(String level) {
        this.level.set(level);
    }

    public String getBirthDate() {
        return birthDate.get();
    }

    public SimpleStringProperty birthDateProperty() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate.set(birthDate);
    }

    public String getIDCard() {
        return IDCard.get();
    }

    public SimpleStringProperty IDCardProperty() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard.set(IDCard);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
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

    public String getIdShop() {
        return idShop.get();
    }

    public SimpleStringProperty idShopProperty() {
        return idShop;
    }

    public void setIdShop(String idShop) {
        this.idShop.set(idShop);
    }


}
