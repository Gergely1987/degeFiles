package TestCollections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Iteratorok {

    public static void main(String[] args) {
        List<String> list1=new LinkedList<>();
        list1.add("Gerike");
        list1.add("Krisz");
        System.out.println(list1);

        Iterator<String> it =list1.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
