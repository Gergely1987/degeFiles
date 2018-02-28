package singleton.producerconsumer;

public class Consumer {
    private Store store;

    public Consumer(Store store) {
        if (store.getProductCount() == 0) {
            throw new IllegalStateException("Store is empty");
        }
        this.store = store;
    }


    public Product consume() {

        Product productToRemove = store.remove();
        return productToRemove;
    }
}
