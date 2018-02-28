package stringtype.stringtype;

public class StringTypeMain {
    public static void main(String[] args) {
        String prefix="Hello";
        String name="John Doe";
        String message=prefix+" "+name;
        System.out.println(message);

        message=message+444;
        System.out.println(message);

        boolean b=message.equals("Hello John Doe");
        System.out.println(b);
        boolean c=message.equals("Hello John Doe444");
        System.out.println(c);

        String d="";
        String e="";
        String f=d+e;
        System.out.println(f.length());

       String a= message.substring(1,2)+message.substring(3,4);
        System.out.println(a);




    }
}
