package person;

public class Adress {
    private String country;
    private String city;
    private String streetAndNumber;
    private String zibCode;

    @Override
    public String toString() {
        return "Adress{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", streetAndNumber='" + streetAndNumber + '\'' +
                ", zibCoe='" + zibCode + '\'' +
                '}';
    }

    public Adress(String country, String city, String streetAndNumber, String zipCode) {
        this.country = country;
        this.city = city;
        this.streetAndNumber = streetAndNumber;
        this.zibCode = zipCode;
    }

    public void correctDate(String country, String city, String streetAndNumber, String zipCode){
        this.country=country;
        this.city=city;
        this.streetAndNumber=streetAndNumber;
        this.zibCode=zipCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreetAndNumber(String streetAndNumber) {
        this.streetAndNumber = streetAndNumber;
    }

    public void setZibCoe(String zibCoe) {
        this.zibCode = zibCoe;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public String getZibCoe() {
        return zibCode;
    }
}
