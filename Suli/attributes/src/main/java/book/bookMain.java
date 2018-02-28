package book;

public class bookMain {
    public static void main(String[] args) {
        Book b1=new Book("álmaim otthona");
        System.out.println(b1.getTitle());
        b1.setTitle("lovagok otthona");

        System.out.println(b1.getTitle());


    }



}
