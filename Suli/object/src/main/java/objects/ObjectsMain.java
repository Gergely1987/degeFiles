package objects;

import java.awt.print.Book;

public class ObjectsMain {
    public static void main(String[] args) {
        Book b=new Book();
        Book emptyBook=null;
        System.out.println(b);
        System.out.println(emptyBook);
        Book book=new Book();
        Book anotherBook=new Book();
        System.out.println(book==anotherBook);
        System.out.println(book.equals(anotherBook));
        System.out.println(anotherBook instanceof Book);

    }
}
