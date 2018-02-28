package genericinterface.search;

import genericinterface.Item;
import genericinterface.SearchCriteria;
import genericinterface.book.BookAuthorSearchCriteria;
import genericinterface.book.BookTitleSearchCriteria;

import java.util.List;

public class SearchService<T extends Item> {


    public T iterating(List<T> items, SearchCriteria criteria) {
        for (T it : items) {
            if (criteria.pass(it)) {
                return it;
            }
        }
        throw new IllegalArgumentException("cannot find the book");
    }

    public T findFirst(List<T> items, SearchCriteria criteria) {
        T item = null;
        if (criteria instanceof BookAuthorSearchCriteria) {
            item = iterating(items, (BookAuthorSearchCriteria) criteria);
        }
        if (criteria instanceof BookTitleSearchCriteria) {
            item = iterating(items, (BookTitleSearchCriteria) criteria);
        }
        return item;
    }
}
