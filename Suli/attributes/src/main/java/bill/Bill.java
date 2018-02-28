package bill;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<Item> items=new ArrayList<Item>();

    public void addItem(Item it) {

        items.add(it);

    }

    public List<Item> getItems() {
        return items;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < items.size(); i++) {
            int q = items.get(i).getQuantity();
            double p = items.get(i).getPrice();
            totalPrice += q * p;
        }

        return totalPrice;

    }

    public static void main(String[] args) {
        Bill b=new Bill();
        Item it1 = new Item("kávé", 1, 10);
        Item it2 = new Item("tea", 2, 10);
        Item it3 = new Item("cukor", 2, 10);
        b.addItem(it1);
        b.addItem(it2);
        b.addItem(it3);
        System.out.println(b.calculateTotalPrice());

    }
}
