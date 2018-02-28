package sorting;

import java.util.Set;
import java.util.TreeSet;

public class OrderedLibrary {
    private Set<Book> library=new TreeSet<>();

    public OrderedLibrary(Set<Book> library) {
        this.library = library;
    }

    public Book lendFirstBook(){
        if(library.isEmpty()){
            throw new NullPointerException("Libray is empty!");
        }
      Book b=library.iterator().next();
        return b;
    }
}
