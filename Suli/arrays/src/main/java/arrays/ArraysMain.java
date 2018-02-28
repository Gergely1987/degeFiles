package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysMain {

    private String[] daysInMonth={"31","28","31","30","31","30","31","31","30","31","30","31"};

    public List <String> daysOfWeek(){
        List <String> a=new ArrayList<>();
        a.add("monday");
        a.add("tuesday");
        a.add("wednesday");
        a.add("thursday");
        a.add("friday");
        a.add("saturday");
        a.add("sunday");

        System.out.println(a);
        return a;
    }

    public String numberOfDaysAsString(){
    String numberOfDays=Arrays.toString(daysInMonth);
return numberOfDays;

}

public String multiplicationTableString (int n){
       String a="";
        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
               a+=i*j+", ";

            }
          //  a+="\n";
        }
    System.out.println(a);
        return a;
}

public boolean sameTempValues(double[]day, double[]anotherDay){
   boolean a=false;
    for (int i=0; i<day.length; i++){
       for (int j=0; j<day.length; j++){
           if(day[i] == anotherDay[j]){
               a=true;
           }
       }
    }
    System.out.println(a);
    return a;

}

    public static void main(String[] args) {
        ArraysMain am=new ArraysMain();
        System.out.println(am.numberOfDaysAsString());
        am.daysOfWeek();
        am.multiplicationTableString(5);

        double a[]={33,32,42,24.4,30};
        double b[]={34,31,20,31,4,5};
        am.sameTempValues(a,b);
    }
}
