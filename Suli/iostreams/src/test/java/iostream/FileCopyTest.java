package iostream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FileCopyTest {

    private File sourceFile;
    private File targetFile;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Rule
    public final TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        targetFile = temporaryFolder.newFile();
        sourceFile = temporaryFolder.newFile();
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sourceFile.getAbsoluteFile()), "UTF-8"))) {
            writer.write("árvíztűrő tükörfúrógép");
        }
    }

    @Test
    public void missingFileShouldThrowException() throws IllegalArgumentException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Source or target file name must not be empty");
        // When
        new FileCopy().copyFile("", "data.dat");
    }

    @Test
    public void missingSourceFileShouldThrowException() throws IllegalArgumentException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Source file cannot be found!");
        // When
        new FileCopy().copyFile("xyz", "data.dat");
    }

    @Test
    public void testCopyFileWFile() {
        //Given
        File targetFile = new File(temporaryFolder.getRoot().getAbsolutePath(), "targetFile.dat");
        new FileCopy().copyFile(sourceFile, targetFile);
        //Then
        assertThat(sourceFile.length() == targetFile.length(), is(true));
    }

    @Test
    public void testCopyFileWString() {
        //When
        new FileCopy().copyFile(this.sourceFile.getAbsolutePath(), this.targetFile.getAbsolutePath());
        //Then
        assertThat(sourceFile.length() == targetFile.length(), is(true));
    }
}
