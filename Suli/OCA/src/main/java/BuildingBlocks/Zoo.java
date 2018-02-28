package BuildingBlocks;

import java.util.Random;

public class Zoo {
private StringMachine a;
private static StringMachine b;

    public static void main(StringMachine[] args) {
      //  int $;
        Zoo z=new Zoo();
        System.out.println(z.a);
        System.out.println(b);
        System.out.println(z.c);
        Random r=new Random();
        System.out.println(r.nextInt(11)+-10); //(bound max+1-min)+min
    }
    int c;
}
