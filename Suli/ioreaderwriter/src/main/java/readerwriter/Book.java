package readerwriter;

public class Book {
private long id;
private String author;
private String title;

    public Book(long id, String title,String author) {
        this.id = id;
        this.title = title;
        this.author = author;

    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return id+":"+title+":"+author;
    }
}
