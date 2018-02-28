package readerwriter;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DataReaderTest {

    private File sourceFile;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Rule
    public final TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        sourceFile = temporaryFolder.newFile();
        Writer fw = new OutputStreamWriter(new FileOutputStream(sourceFile.getAbsoluteFile()), DataReader.CHARSET_UTF8);
        fw.write("1:Fekete István:Téli berek\n" +
                "2:Fekete István:Tüskevár\n" +
                "3:Jókai Mór:Az aranyember");
        fw.close();
    }

    @Test
    public void missingSourceFileShouldThrowException() throws IllegalArgumentException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("File not found:");
        // When
        new DataReader().readBookData("xyz.txt");
    }

    @Test
    public void emptyFileNameShouldThrowException() throws IllegalArgumentException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("File name must not be empty!");
        // When
        new DataReader().readBookData("");
    }

    @Test
    public void emptyEncodingShouldThrowException() throws IllegalArgumentException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Encoding must not be empty!");
        // When
        new DataReader().readBookData("xyz.txt", "");
    }

    @Test
    public void testReadBookData() {
        //When
        List<Book> bookList = new DataReader().readBookData(sourceFile.getAbsolutePath(), DataReader.CHARSET_UTF8);
        //Then
        assertThat(bookList.toString(), equalTo("[1:Fekete István:Téli berek, 2:Fekete István:Tüskevár, 3:Jókai Mór:Az aranyember]"));
    }
}
