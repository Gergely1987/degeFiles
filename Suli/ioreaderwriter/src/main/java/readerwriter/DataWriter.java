package readerwriter;

import java.io.*;
import java.util.List;

public class DataWriter {
    public static String CHARSET_UTF8 = "UTF-8";


    public void writeBookData(List<Book> bookList, String fileName, String encoding) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("File name must not be empty!");
        }
        if (isEmpty(encoding)) {
            throw new IllegalArgumentException("Encoding must not be empty!");
        }

        StringBuilder sb = new StringBuilder("");

        for (Book b : bookList) {
            // System.out.println(b.getAuthor());
            sb.append(b.toString()).append("\n");
        }
        String books = sb.toString().trim();
        System.out.println(books);
            try (
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), encoding))) {
                    bw.write(books);
                } catch (IOException e) {
                    e.printStackTrace();
                }
    }

    public void writeBookData(List<Book> bookList, String fileName) {
        writeBookData(bookList, fileName, CHARSET_UTF8);
    }

    boolean isEmpty(String str) {
        if (str == null || str.trim().isEmpty()) {
            return true;
        }
        return false;
    }

}
