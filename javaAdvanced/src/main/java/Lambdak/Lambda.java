package Lambdak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Lambda {

    public void letsDoThis(int a, Growl g){
        g.growling(a);
    }

    public static void main(String[] args) {
//
//        Program pg=new Program();
//
//       Growl growling=()->{System.out.println("Grrrrr");};
//
//       pg.doSomething(growling);
        ArrayList<Person> people=new ArrayList<>(Arrays.asList(new Person(20,"petya"),new Person(10,"sanya"),new Person(33,"gizi"),new Person(3,"koki")));
//        people.sort(new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return 0;
//            }
//        });

        people.sort((Person p1, Person p2)->p1.getName().compareTo(p2.getName()));
        System.out.println(people);

        people.sort(( p1, p2)->p1.getAge()-p2.getAge());

        System.out.println(people);

        Lambda lambda=new Lambda();
        lambda.letsDoThis(2, b->{
            System.out.println("This is lambda");
        });
    }
}
