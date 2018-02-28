package searching;

import java.util.Arrays;

public class BookArraySearch {

    private Book[] bookArray;

    public BookArraySearch(Book[] bookArray) {
        this.bookArray = bookArray;
    }




    public Book findBookByAuthorTitle(String author, String title) {
        if (author.isEmpty() || title.isEmpty()) {
            throw new IllegalArgumentException("Author or title must not be empty!");
        }
        Book[]books= Arrays.copyOf(bookArray,bookArray.length);
        Arrays.sort(books);
        int a=Arrays.binarySearch(books,new Book(0,author,title));
        if(a>=0){
            return books[a];

        }
        else{
            throw new IllegalArgumentException("No book found by " + author + " with title " + title);
        }
    }

}
