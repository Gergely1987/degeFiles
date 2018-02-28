package finalmodifier;

public class TaxCalculator {
    final double VAT=0.27;

    public double tax(double price){
        double tax=price*VAT;
        System.out.println(tax);
        return  tax;
    }

    public double priceWithtax(double price){
        double finalPrice=(1+VAT)*price;
        System.out.println(finalPrice);
        return finalPrice;
    }

    public static void main(String[] args) {
        TaxCalculator tc=new TaxCalculator();
        tc.tax(10);
        tc.priceWithtax(10);
    }
}
