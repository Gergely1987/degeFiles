package ioresource;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.InputStream;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ResourceReaderTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void missingResourceShouldThrowException() throws DataException {
        // Given
        exception.expect(DataException.class);
        exception.expectMessage("Resource cannot be found!");
        // When
        new ResourceReader().readResource("xyz");
    }

    @Test
    public void testReadResource() {
        //Given
        List<Book> bookList = new ResourceReader().readResource("bookData.dat");
        //Then
        assertThat(bookList.toString(), equalTo("[12:Téli Berek:Fekete István, 24:Tüskevár:Fekete István, 32:Az aranyember:Jókai Mór]"));
    }

    @Test
    public void testReadBookData() {
        //Given
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("bookTestData.dat");
        //When
        List<Book> bookList = new ResourceReader().readBookData(in);
        //Then
        assertThat(bookList.toString(), equalTo("[12:Téli Berek:Fekete István, 24:Tüskevár:Fekete István, 32:Az aranyember:Jókai Mór]"));
    }

    @Test
    public void incorrectResourceShouldThrowException() throws DataException {
        // Given
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("wrongDataLine.dat");
        exception.expect(DataException.class);
        exception.expectMessage("Data corrupted at:");
        // When
        new ResourceReader().readBookData(in);
    }

    @Test
    public void nonParsableResourceShouldThrowException() throws DataException {
        // Given
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("nonParsableData.dat");
        exception.expect(DataException.class);
        exception.expectMessage("Data cannot be read or data corrupted at line:");
        // When
        new ResourceReader().readBookData(in);
    }
}
