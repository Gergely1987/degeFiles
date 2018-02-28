package collectionscomp;

import java.text.Collator;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class OrderedLibrary {

    private List<Book> books = new LinkedList<>();

    public OrderedLibrary(List<Book> books) {
        this.books = books;
    }

    public List<Book> orderedByTitle() {
        List<Book> newList = new LinkedList<>(books);
        Collections.sort(newList, new TitleComparator());
        return newList;
    }

    public List<Book> orderedByAuthor() {
        List<Book> newList = new LinkedList<>(books);
        Collections.sort(newList, new AuthorComparator());
        return newList;
    }

    public List<String> orderedByTitleLocale(Locale locale) {
        List<String> newList = new LinkedList<>();
        for (Book b:books) {
            newList.add(b.getTitle());
        }

        Collections.sort(newList,Collator.getInstance(locale));
        return newList;
    }


}
