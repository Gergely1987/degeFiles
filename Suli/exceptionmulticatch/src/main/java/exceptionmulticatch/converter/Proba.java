package exceptionmulticatch.converter;

public class Proba {
    String s;
    int i;

    public Proba(String s, int i) {
        this.s = s;
        this.i = i;
    }

    public static void main(String[] args) {



        ProbaParser pb=new ProbaParser();
        pb.parse("ez,12");
        System.out.println(pb);
        System.out.println(pb.parse("ez,12"));
    }
}
