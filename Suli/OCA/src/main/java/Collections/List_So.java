package Collections;

import java.util.ArrayList;
import java.util.List;

public class List_So {
    public static void main(String[] args) {
//        List<String> birds = new ArrayList<>();
//        birds.add("hawk");
//        birds.add("hawk");
//        birds.add("hawk1");
//        System.out.println(birds);
//        birds.remove("hawk");
//        System.out.println(birds);
//          birds.remove("hawk");
//        System.out.println(birds);
//
//        //   System.out.println( birds.remove("hawk"));
//        System.out.println(birds.contains("hawk1"));
//

//       List<Integer>numberÜ=new ArrayList();
//       numberÜ.add(1);
//       numberÜ.add(2);
//       numberÜ.add(new Integer(3));
//       numberÜ.remove(1);
//        System.out.println(numberÜ);
//        numberÜ.remove(new Integer(3));
//        System.out.println(numberÜ);

        List<String>ez=new ArrayList<>();
        ez.add("alma");
        ez.add("robin");



        Object oA=ez.toArray();

       Object[]stringA= ez.toArray();
       String[]stringB=ez.toArray(new String[112]);
        System.out.println(stringA[1]);
        System.out.println(stringB[0]);

    }
}
