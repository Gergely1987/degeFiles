package nestedclasses.webshop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WebShop {
    private List<Product> products=new ArrayList<>();

    public void addProducts(Product product) {
        products.add(product);
    }

    public List<Product> getProductsOrderByName() {
        List<Product> newList = new ArrayList<>(products);
        newList.sort(new Comparator<Product>()  {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().toLowerCase().compareTo(p2.getName().toLowerCase());
            }
        });
        return newList;
    }

    public List<Product>getProductsOrderByPrice(){
        List<Product> newList = new ArrayList<>(products);
        newList.sort(new Comparator<Product>()  {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getPrice()-(p2.getPrice());
            }
        });
        return newList;
    }


    public List<Product>getProductsOrderByFrom(){
        List<Product> newList = new ArrayList<>(products);
        newList.sort(new Comparator<Product>()  {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getFrom().compareTo(p2.getFrom());
            }
        });
        return newList;

    }



}
