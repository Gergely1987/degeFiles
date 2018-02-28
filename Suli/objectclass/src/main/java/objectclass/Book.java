package objectclass;

public class Book {
    private String author;
    private String title;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

//    @Override
//    public int hashCode() {
//        int result = author != null ? author.hashCode() : 0;
//        result = 31 * result + (title != null ? title.hashCode() : 0);
//        return result;
//    }

}
