package introconstructors;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<String> menu;
    private String name;
    private int capacity;

    public List<String>fillMenu(String... str){
        List<String>newMenu=new ArrayList<String>();
        for (int i=0; i<str.length; i++){
            newMenu.add(str[i]);
        }

        return newMenu;
    }

    public Restaurant(String name, int numberOfTables, String... str) {
        this.name = name;
        this.capacity = numberOfTables * 4;
        this.menu=fillMenu(str);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "menu=" + menu +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    public static void main(String[] args) {
        Restaurant rs=new Restaurant("BeBár", 4,"alma","bele","körte");
        String s=rs.toString();
        System.out.println(s);

    }
}
