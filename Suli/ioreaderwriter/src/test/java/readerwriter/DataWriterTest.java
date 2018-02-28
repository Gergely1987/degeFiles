package readerwriter;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DataWriterTest {

    private File targetFile;
    private List<Book> bookList;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Rule
    public final TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        targetFile = temporaryFolder.newFile();
        bookList = Arrays.asList(new Book(1L, "Téli berek", "Fekete István"),
                new Book(15L, "Tüskevár", "Fekete István"),
                new Book(25L, "Az aranyember", "Jókai Mór"));
    }

    @Test
    public void emptyFileNameShouldThrowException() throws IllegalArgumentException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("File name must not be empty!");
        // When
        new DataWriter().writeBookData(bookList, "");
    }

    @Test
    public void emptyEncodingShouldThrowException() throws IllegalArgumentException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Encoding must not be empty!");
        // When
        new DataWriter().writeBookData(bookList, "xyz.txt", "");
    }

    @Test
    public void testWriteBookData() throws IOException {
        //When
        new DataWriter().writeBookData(bookList, targetFile.getAbsolutePath(), DataReader.CHARSET_UTF8);
        //Then
        assertThat(readFile(targetFile.getAbsolutePath()), equalTo("1:Téli berek:Fekete István\n15:Tüskevár:Fekete István\n25:Az aranyember:Jókai Mór"));
    }

    //helper method, to read a file content for testing

    private String readFile(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder("");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), DataReader.CHARSET_UTF8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString().trim();
    }
}
