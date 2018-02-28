package collectionsautoboxing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Autoboxing {

    public List<Integer> createList(int... numbers){
        List<Integer>newList=new LinkedList<>();
        for (int i:numbers) {
            newList.add(i);
        }
        return newList;
    }
    public int sumIntegerList(List<Integer> integerList){
       int sum=0;
        for (Integer i:integerList) {
            sum+=i;
        }
        return sum;
    }
    public int sumIntegerObjects(Integer... integers){
        int sum=0;
        for (Integer i:integers) {
            sum+=i;
        }
        return sum;
    }

    public static void main(String...s){

    }

}
