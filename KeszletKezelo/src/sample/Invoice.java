package sample;

import javafx.beans.property.SimpleStringProperty;

public class Invoice {


    private final SimpleStringProperty name;
    private final SimpleStringProperty type;
    private final SimpleStringProperty year;
    private final SimpleStringProperty piece;
    private final SimpleStringProperty price;
    private final SimpleStringProperty shopID;
    private final SimpleStringProperty partnerID;
    private final SimpleStringProperty finalPrice;
    private final SimpleStringProperty id;

    public String getPartnerID() {
        return partnerID.get();
    }

    public SimpleStringProperty partnerIDProperty() {
        return partnerID;
    }

    public void setPartnerID(String partnerID) {
        this.partnerID.set(partnerID);
    }

    public String getFinalPrice() {
        return finalPrice.get();
    }

    public SimpleStringProperty finalPriceProperty() {
        return finalPrice;
    }

    public void setFinalPrice(String finalPrice) {
        this.finalPrice.set(finalPrice);
    }

//    public Invoice(String name, String type, String year, String piece, String price, String shopID, String finalPrice,String id){
//        this.name=new SimpleStringProperty("");
//        this.type=new SimpleStringProperty("");
//        this.year=new SimpleStringProperty("");
//        this.piece=new SimpleStringProperty("");
//        this.price=new SimpleStringProperty("");
//        this.shopID=new SimpleStringProperty("");
//        this.partnerID=new SimpleStringProperty("");
//        this.finalPrice=new SimpleStringProperty("");
//        this.id=new SimpleStringProperty("");
//    }

    public Invoice(String name, String type, String year, String piece, String price, String shopID, String partnerID){
        this.name=new SimpleStringProperty(name);
        this.type=new SimpleStringProperty(type);
        this.year=new SimpleStringProperty(year);
        this.piece=new SimpleStringProperty(piece);
        this.price=new SimpleStringProperty(price);
        this.shopID=new SimpleStringProperty(shopID);
        this.partnerID=new SimpleStringProperty(partnerID);
        this.finalPrice=new SimpleStringProperty("");
        this.id=new SimpleStringProperty("");

    }

    public Invoice(String name, String type, String year, String piece, String price, String shopID){
        this.name=new SimpleStringProperty(name);
        this.type=new SimpleStringProperty(type);
        this.year=new SimpleStringProperty(year);
        this.piece=new SimpleStringProperty(piece);
        this.price=new SimpleStringProperty(price);
        this.shopID=new SimpleStringProperty(shopID);
        this.partnerID=new SimpleStringProperty("");
        this.finalPrice=new SimpleStringProperty("");
        this.id=new SimpleStringProperty("");

    }

    public Invoice(Integer id, String name, String type, String year, String piece, String price, String shopID){
        this.name=new SimpleStringProperty(name);
        this.type=new SimpleStringProperty(type);
        this.year=new SimpleStringProperty(year);
        this.piece=new SimpleStringProperty(piece);
        this.price=new SimpleStringProperty(price);
        this.shopID=new SimpleStringProperty(shopID);
        this.partnerID=new SimpleStringProperty("");
        this.finalPrice=new SimpleStringProperty("");
        this.id=new SimpleStringProperty("");

    }

    public Invoice(String name, String type, String year, String piece, String price, String shopID,String finalPrice, String partnerID){
        this.name=new SimpleStringProperty(name);
        this.type=new SimpleStringProperty(type);
        this.year=new SimpleStringProperty(year);
        this.piece=new SimpleStringProperty(piece);
        this.price=new SimpleStringProperty(price);
        this.shopID=new SimpleStringProperty(shopID);
        this.partnerID=new SimpleStringProperty(partnerID);
        this.finalPrice=new SimpleStringProperty(finalPrice);
        this.id=new SimpleStringProperty("");

    }

    @Override
    public String toString() {
        return "Invoice{" +
                "name=" + name +
                ", type=" + type +
                ", year=" + year +
                ", piece=" + piece +
                ", price=" + price +
                ", shopID=" + shopID +
                ", partnerID=" + partnerID +
                ", finalPrice=" + finalPrice +
                ", id=" + id +
                '}';
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

    public String getYear() {
        return year.get();
    }

    public SimpleStringProperty yearProperty() {
        return year;
    }

    public void setYear(String year) {
        this.year.set(year);
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

    public String getShopID() {
        return shopID.get();
    }

    public SimpleStringProperty shopIDProperty() {
        return shopID;
    }

    public void setShopID(String shopID) {
        this.shopID.set(shopID);
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
}
