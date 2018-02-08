package sample;

import javafx.beans.property.SimpleStringProperty;

public class Shop {
    private final SimpleStringProperty shopName;
    private final SimpleStringProperty areaCode;
    private final SimpleStringProperty city;
    private final SimpleStringProperty street;
    private final SimpleStringProperty streetNum;
    private final SimpleStringProperty id;

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public Shop(){
    this.shopName=new SimpleStringProperty("");
    this.areaCode=new SimpleStringProperty("");
    this.city=new SimpleStringProperty("");
    this.street=new SimpleStringProperty("");
    this.streetNum=new SimpleStringProperty("");
    this.id=new SimpleStringProperty("");
    }

    public Shop(String shopName, String areaCode, String city, String street, String streetNum){
        this.shopName=new SimpleStringProperty(shopName);
        this.areaCode=new SimpleStringProperty(areaCode);
        this.city=new SimpleStringProperty(city);
        this.street=new SimpleStringProperty(street);
        this.streetNum=new SimpleStringProperty(streetNum);
        this.id=new SimpleStringProperty("");
    }

    public Shop(Integer id, String shopName, String areaCode, String city, String street, String streetNum){
        this.shopName=new SimpleStringProperty(shopName);
        this.areaCode=new SimpleStringProperty(areaCode);
        this.city=new SimpleStringProperty(city);
        this.street=new SimpleStringProperty(street);
        this.streetNum=new SimpleStringProperty(streetNum);
        this.id=new SimpleStringProperty(String.valueOf(id));
    }


    public String getShopName() {
        return shopName.get();
    }

    public SimpleStringProperty shopNameProperty() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName.set(shopName);
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
}
