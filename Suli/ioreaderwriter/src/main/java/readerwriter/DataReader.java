package readerwriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    public static String CHARSET_UTF8 = "UTF-8";

    public List<Book> readBookData(String fileName) {
        return readBookData(fileName, "UTF-8");
    }

    public List<Book> readBookData(String fileName, String encoding) {

        if (fileName.isEmpty()) {
            throw new IllegalArgumentException("File name must not be empty!");
        }
        if (encoding.isEmpty()) {
            throw new IllegalArgumentException("Encoding must not be empty!");
        }
        File f = new File(fileName);
        if (!f.exists()) {
            throw new IllegalArgumentException("File not found:");
        }
        List<Book> books = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String s;

            while ((s = br.readLine()) != null) {
                String[] arr = s.split(":");
                books.add(new Book(Integer.parseInt(arr[0]), arr[1], arr[2]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
}
