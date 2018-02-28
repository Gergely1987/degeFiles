package methodstructure.pendrives;

public class Pendrive {
    private String name;
    private int capacity;
    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pendrive{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }

    public void risePrice(int percent){
       price= price*(100+percent)/100;
    }

    public int comparePricePerCapacity(Pendrive pendr){
        double result=((price*100.0)/capacity);
        double resultPendr=((pendr.price*100.0)/pendr.capacity);
        int dif=0;

        if(result>resultPendr){
            dif=1;
        } else if(result<resultPendr){
            dif=-1;
        }
        return dif;
    }

    public boolean cheaperThan(Pendrive pendr){
        if(price<pendr.price){
            return true;
        }
        return false;
    }
}
