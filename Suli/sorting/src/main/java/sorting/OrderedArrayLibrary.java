package sorting;

import java.util.Arrays;

public class OrderedArrayLibrary {
    Book[]books;
    public OrderedArrayLibrary(Book[] bookArray){
        this.books=bookArray;
    }
    public Book[] sortingById(){
        Book[]sortedBooks=Arrays.copyOf(books,books.length);
        Arrays.sort(sortedBooks,new ComparatorId());
        return sortedBooks;
    }
    public Book[] sortingByTitle(){
        Book[]sortedBooks=Arrays.copyOf(books,books.length);
        Arrays.sort(sortedBooks,new ComparatorTitle());
        return sortedBooks;
    }

}
