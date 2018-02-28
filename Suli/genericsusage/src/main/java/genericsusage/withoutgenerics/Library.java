package genericsusage.withoutgenerics;


import genericsusage.Book;

import java.util.ArrayList;
import java.util.List;

public class Library {
    public Book getFirstBook(List books) {
        if (books == null) {
            throw new NullPointerException();
        }
        if (books.isEmpty()) {
            throw new IllegalArgumentException("Argument should not be empty");
        }

        Book firstBook;

        try {
            firstBook = (Book) books.get(0);
            return firstBook;
        } catch (ClassCastException cce) {
            throw new ClassCastException("Not a book");
        }
    }


}
