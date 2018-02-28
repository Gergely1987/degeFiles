import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class LocalDate_Time {

    public static void main(String[] args) {
        LocalDate localDate=LocalDate.of(2017,11,9);
        LocalDate localDateEnd=localDate.of(2017,12,31);
        LocalTime lt=LocalTime.now();
        LocalDateTime ldt=LocalDateTime.of(localDate, lt);
        Period everyWeek=Period.ofWeeks(1);

        Period wrong=Period.ofYears(1);
        wrong=Period.ofWeeks(2).ofDays(1);
        System.out.println(localDate.plus(wrong));
        LocalDate upTo=localDate;

        while (upTo.isBefore(localDateEnd)) {
           // System.out.println(localDate.getMonth());
           upTo= upTo.plusWeeks(1);
         //   System.out.println(upTo.getMonth());
        }

        DateTimeFormatter f=DateTimeFormatter.ofPattern("hh:mm");
      //  System.out.println(f.format(localDate));
        System.out.println(f.format(lt));
        System.out.println(f.format(ldt));

        LocalTime lt1=LocalTime.parse("22:22");
        System.out.println(lt1);

        DateTimeFormatter dtf2=DateTimeFormatter.ofPattern("MM dd yyyy");
        LocalDate ld1=LocalDate.parse("01 11 1988", dtf2);
        System.out.println(ld1);

        int i=3;
        String a="alma";
        StringBuilder sb=new StringBuilder("alma");

        System.out.println(a.substring(0,2));
        a+="i";
        a+='a';
        System.out.println(a);
       StringBuilder numbers=new StringBuilder("0123456789");
       numbers.delete(2,3);
       numbers.append(true);
        System.out.println(numbers);
        System.out.println(numbers.reverse());

       String []names={"Tom", "Dick", "Harry"};
        List<String> list= Arrays.asList();
        names[0]="talánEz";
        list.set(0,"Sue");

        names[0].l

        System.out.println(names[0]);
    }
}
