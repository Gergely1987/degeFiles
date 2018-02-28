package niopath;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    public static final String CONTENT = "12:Core Java:Cay Horstmann\n" +
            "42:Hitchhikers Guide to the Galaxy:Douglas Adams\n" +
            "57:Core JavaServer Faces:Geary&Horstmann";

    private String testDirectoryName;
    private Library library;
    private Path path;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        library = new Library();
        testDirectoryName = folder.getRoot().getAbsolutePath();
        path = Paths.get(testDirectoryName, "bookList.dat");
    }

    @Test
    public void nonparseableDataShouldThrowException() throws IOException {
        // Given
        String unparseableData = "12:Core Java:Cay Horstmann\n" +
                "42:Hitchhikers Guide to the Galaxy:Douglas Adams\n" +
                "a57:Core JavaServer Faces:Geary&Horstmann"; //non-parseable id
        Files.write(path, unparseableData.getBytes());
        exception.expect(IOException.class);
        exception.expectMessage("Non-parseable book data!");
        // When
        library.loadBooksFromFile(path);
    }

    @Test
    public void wrongDataShouldThrowException() throws IOException {
        // Given
        String wrongData = "12:Core Java:Cay Horstmann\n" +
                "42:Hitchhikers Guide to the Galaxy:Douglas Adams\n" +
                "57:Core JavaServer Faces"; //missing author field
        Files.write(path, wrongData.getBytes());
        exception.expect(IOException.class);
        exception.expectMessage("Wrong book data!");
        // When
        library.loadBooksFromFile(path);
    }

    @Test
    public void testLoadBooksFromFile() throws IOException {
        //When
        Files.write(path, CONTENT.getBytes());
        library.loadBooksFromFile(path);
        //Then
        assertThat(library.bookListSize(), equalTo(3));
    }

    @Test
    public void testWriteBookListToFile() throws IOException {
        //Given
        Files.write(path, CONTENT.getBytes());
        library.loadBooksFromFile(path);
        Path resultPath = Paths.get(testDirectoryName, "bookStore.dat");
        //When
        library.writeBookListToFile(resultPath);
        //Then
        assertThat(library.bookListSize(), equalTo(3));
        assertThat(resultPath.toFile().length() == path.toFile().length(), is(true));
    }
}
