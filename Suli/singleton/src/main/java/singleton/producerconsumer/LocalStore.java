package singleton.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class LocalStore implements Store {
    private List<Product> products = new ArrayList<>();
    static int CAPACITY = 3000;
    private static LocalStore INSTANCE=new LocalStore();


    public List<Product> getProducts() {
        return products;
    }


    public static LocalStore getInstance() {
        return INSTANCE;
    }

    @Override
    public void add(Product product) {
        if (products.size()==CAPACITY) {
           return;
        } else{
            products.add(product);
        }

    }

    @Override
    public Product remove() {
        if (products.size() == 0) {
            throw new IllegalStateException("Store is empty");
        }
        Product itemToRemove=products.remove(0);
        products.remove(itemToRemove);
        return itemToRemove;
    }

    @Override
    public void reset() {
        products.clear();

    }

    @Override
    public int getProductCount() {
        return products.size() ;
    }
}
