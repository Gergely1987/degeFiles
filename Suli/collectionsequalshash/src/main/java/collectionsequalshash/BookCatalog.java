package collectionsequalshash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookCatalog {
    private List<Book>books=new ArrayList<>();

    public Book findBookByTitleAuthor(List<Book> books, String title, String author){

        for (Book searchedBook:books){
            if(searchedBook.getAuthor().equals(author)){
                return searchedBook;
            }
        }
        return null;
    }


    public Book findBook(List<Book> books, Book book){
        for (Book searchedBook:books) {
            if(searchedBook.equals(book)){
                return searchedBook;
            }
        }
        return null;
    }
    public Set<Book> addBooksToSet(Book[] books){
            Set<Book>newSetBooks=new HashSet<>();

        for (int i = 0; i <books.length; i++) {
            //this.books.add(books[i]);
            newSetBooks.add(books[i]);
        }
      //  Set<Book> totalBooks=new HashSet<Book>(this.books);

      //  return totalBooks;
        return newSetBooks;
    }


}
