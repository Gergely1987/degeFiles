package sorting;

public class Book implements Comparable<Book>{
    private int id;
    private String title;
    private String author;

    @Override
    public int compareTo(Book o) {
        return id-o.id;
    }

    public Book(int id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

