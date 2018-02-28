package genericinterface.book;

import genericinterface.Item;
import genericinterface.SearchCriteria;

public class BookAuthorSearchCriteria implements SearchCriteria {
    private String author;

    public BookAuthorSearchCriteria(String author) {
        this.author = author;
    }


    @Override
    public boolean pass(Item target) {
        return author.equals(((Book)target).getAuthor());
    }
}
