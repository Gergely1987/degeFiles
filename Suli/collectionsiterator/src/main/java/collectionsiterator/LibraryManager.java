package collectionsiterator;

import java.util.*;

public class LibraryManager {

    private Set<Book> libraryBooks=new HashSet<>();

    public LibraryManager(Set<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public int libraryBooksCount(){
        return libraryBooks.size();
    }


    public Book findBookByRegNumber(int regNumber){
            Book result;
            for(Iterator<Book>b=libraryBooks.iterator(); b.hasNext();){
                Book book=b.next();
                if(book.getRegNumber()==regNumber){
                    result=book;
                    return result;
                }
            }

                throw new MissingBookException("No books found with regnumber:");


    }
    public int removeBookByRegNumber(int regNumber){
          Book result;
          for(Iterator<Book>b=libraryBooks.iterator(); b.hasNext();){
              Book book=b.next();
              if(book.getRegNumber()==regNumber){
                  //result=book;
                  libraryBooks.remove(book);
                  return book.getRegNumber();
              }
          }
        //  libraryBooks.remove(result);
        throw new MissingBookException("No books found with regnumber:");
    }

    public Set<Book> selectBooksByAuthor(String author){
        Set<Book>books=new HashSet<>();
        Iterator<Book>i=libraryBooks.iterator();
        while(i.hasNext()){
            Book b=i.next();
            if(b.getAuthor()==author){
                books.add(b);

            }
        }
        if(books.size()>0){
            return books;
        }
        throw new MissingBookException("No books found by");
    }

}
