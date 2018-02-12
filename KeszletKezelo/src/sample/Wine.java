package sample;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Wine {
    //SIMPLESTRINGPROPERTY képes kommunikálni az adattáblával, kompatibils a tableview elemekkel
    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty type;
    private final SimpleStringProperty year;
    private final SimpleStringProperty piece;
    private final SimpleStringProperty price;
    private final SimpleStringProperty date;
    private final SimpleStringProperty shopID;
    private final SimpleStringProperty toShopID;


    public String getToShopID() {
        return toShopID.get();
    }

    public SimpleStringProperty toShopIDProperty() {
        return toShopID;
    }

    public void setToShopID(String toShopID) {
        this.toShopID.set(toShopID);
    }

    public String getShopID() {
        return shopID.get();
    }

    public SimpleStringProperty shopIDProperty() {
        return shopID;
    }

    public void setShopID(String shopID) {
        this.shopID.set(shopID);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getYear() {
        return year.get();
    }

    public SimpleStringProperty yearProperty() {
        return year;
    }

    public void setYear(String year) {
        this.year.set(year);
    }



    public Wine(){
        this.id=new SimpleStringProperty("");
        this.name=new SimpleStringProperty("");
        this.type=new SimpleStringProperty("");
        this.year=new SimpleStringProperty("");
        this.piece=new SimpleStringProperty("");
        this.price=new SimpleStringProperty("");
        this.date=new SimpleStringProperty("");
        this.shopID=new SimpleStringProperty("");
        this.toShopID=new SimpleStringProperty("");
    }

    public Wine(String name, String type, String year, String piece, String price, String shopID,String date){
        this.name=new SimpleStringProperty(name);
        this.type=new SimpleStringProperty(type);
        this.year=new SimpleStringProperty(year);
        this.piece=new SimpleStringProperty(piece);
        this.price=new SimpleStringProperty(price);
        this.shopID=new SimpleStringProperty(shopID);
        this.id=new SimpleStringProperty("");
        this.toShopID=new SimpleStringProperty("");
        this.date=new SimpleStringProperty( date);
    }

    public Wine(Integer id,String name, String type, String piece, String year, String price, String shopID,String date ){
        this.name=new SimpleStringProperty(name);
        this.type=new SimpleStringProperty(type);
        this.piece=new SimpleStringProperty(piece);
        this.year=new SimpleStringProperty(year);
        this.price=new SimpleStringProperty(price);
        this.date=new SimpleStringProperty(date);
        this.shopID=new SimpleStringProperty(shopID);
        this.id=new SimpleStringProperty(String.valueOf(id));
        this.toShopID=new SimpleStringProperty("");
    }

    public Wine(String name,String type,String year,String piece,String price,String shopID){
        this.name=new SimpleStringProperty(name);
        this.type=new SimpleStringProperty(type);
        this.piece=new SimpleStringProperty(piece);
        this.year=new SimpleStringProperty(year);
        this.price=new SimpleStringProperty(price);
        this.shopID=new SimpleStringProperty(shopID);
        this.id=new SimpleStringProperty("");
        this.date=new SimpleStringProperty("");
        this.toShopID=new SimpleStringProperty("");
    }
    public Wine(String name,String type,String year,String piece,String price,String fromShopID,String toShopID,String date){
        this.name=new SimpleStringProperty(name);
        this.type=new SimpleStringProperty(type);
        this.piece=new SimpleStringProperty(piece);
        this.year=new SimpleStringProperty(year);
        this.price=new SimpleStringProperty(price);
        this.shopID=new SimpleStringProperty(fromShopID);
        this.toShopID=new SimpleStringProperty(toShopID);
        this.id=new SimpleStringProperty("");
        this.date=new SimpleStringProperty(date);

    }
//    public Wine(String name,String type,String year,Integer piece,Integer price,String shopID){
//        this.name=new SimpleStringProperty(name);
//        this.type=new SimpleStringProperty(type);
//        this.piece=new SimpleStringProperty(String.valueOf(piece));
//        this.year=new SimpleStringProperty(year);
//        this.price=new SimpleStringProperty(String.valueOf(price));
//        this.shopID=new SimpleStringProperty(shopID);
//        this.id=new SimpleStringProperty("");
//        this.date=new SimpleStringProperty("");
//    }




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

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getPiece() {
        return piece.get();
    }

    public SimpleStringProperty pieceProperty() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece.set(piece);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    @Override
    public String toString() {
        return
               "fajta"+ name +
                ", típus: " + type +
                ", év:" + year +
                ", darab: " + piece +
                ", ár:" + price +
                ", üzletID" + shopID
                ;
    }
}
