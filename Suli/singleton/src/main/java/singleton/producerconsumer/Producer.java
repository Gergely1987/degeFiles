package singleton.producerconsumer;

public class Producer {
    private Store store;

    public Producer(Store store){
        this.store=store;
    }

    public Product produce(String name){
      Product newProduct=new Product(name);
        store.add(newProduct);
      return  newProduct;
    }
}
