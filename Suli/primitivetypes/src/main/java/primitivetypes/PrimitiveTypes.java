package primitivetypes;

import java.util.Arrays;

public class PrimitiveTypes {

    public String toBinaryString(int n) {
        String a = "";
        String result = "";

        int b = 0;

        while (n / 2 > 0) {
            b = n % 2;
            n /= 2;
            a += Integer.toString(b);
        }
        a += 1;

        for (int i = a.length() - 1; i >= 0; i--) {
            result += a.charAt(i);
        }

        for (int i = 0; i < 32; i++) {
            if (result.length() < 32) {
                result = 0 + result;
            }
        }



        return result;
    }


    public static void main(String[] args) {


        PrimitiveTypes pt = new PrimitiveTypes();

        System.out.println(Integer.toString(100, 2));
        System.out.println(Integer.toString(100, 8));
        System.out.println(Integer.toString(100, 16));
        System.out.println(Integer.toBinaryString(100));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println((1.0 / 0) / (-1.0 / 0));

        System.out.println(pt.toBinaryString(723));
        System.out.println(Integer.toString(723, 2));
        System.out.println();
        System.out.println(pt.toBinaryString(100));
        System.out.println(Integer.toString(100, 2));
        System.out.println(Integer.toBinaryString(-5));
        System.out.println();
        System.out.println(pt.toBinaryString(101));
        System.out.println(Integer.toString(101, 2));
        System.out.println();
        System.out.println(pt.toBinaryString(441));
        System.out.println(Integer.toString(441, 2));


    }
}
