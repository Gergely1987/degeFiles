package packages.strings;

public class NumberConcatenator {

    public String concatenate(int a, int b) {
        return Integer.toString(a).concat(Integer.toString(b));
    }

    public static void main(String[] args) {
        NumberConcatenator sc = new NumberConcatenator();

        System.out.println(sc.concatenate(1, 3));
    }
}
