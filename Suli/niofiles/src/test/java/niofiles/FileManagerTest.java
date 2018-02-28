package niofiles;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.StandardCopyOption;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FileManagerTest {

    public FileManager manager;
    public String testDirectoryName;
    public String testFileName;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        manager = new FileManager();
        testDirectoryName = folder.getRoot().getAbsolutePath();
        File testFile = new File(testDirectoryName + File.separator + "test.dat");
        testFile.createNewFile();
        testFileName = testFile.getAbsolutePath();
    }

    @After
    public void tearDown() {
        manager = null;
        testDirectoryName = null;
        testFileName = null;
    }

    @Test
    public void emptyFilePathShouldThrowException() throws IllegalArgumentException, IOException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Path must not be empty!");
        // When
        manager.createFile("", "testFile.txt");
    }

    @Test
    public void testCreateFile() throws IOException {
        //When
        manager.createFile(testDirectoryName, "testFile.txt");
        //Then
        assertThat(new File(testDirectoryName + File.separator + "testFile.txt").exists(), is(true));
    }

    @Test
    public void emptyPathNameShouldThrowException() throws IllegalArgumentException, IOException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Path or directory name must not be empty!");
        // When
        manager.createSubDirectory("", "testFile.txt");
    }

    @Test
    public void testCreateSubDirectory() throws IOException {
        //When
        manager.createSubDirectory(testDirectoryName, "testDir");
        //Then
        assertThat(new File(testDirectoryName, "testDir").exists(), is(true));
    }

    @Test
    public void emptySourceNameShouldThrowException() throws IllegalArgumentException, IOException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Source name must not be empty!");
        // When
        manager.copyFile("", testDirectoryName, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    public void testCopyFile() throws IOException {
        String copyTo = testDirectoryName + File.separator + "copiedFile.dat";
        //When
        manager.copyFile(testFileName, copyTo, StandardCopyOption.REPLACE_EXISTING);
        //Then
        assertThat(new File(copyTo).exists(), is(true));
    }

    @Test
    public void nullInputStreamShouldThrowException() throws NullPointerException, IOException {
        // Given
        exception.expect(NullPointerException.class);
        exception.expectMessage("Source must not be null!");
        // When
        manager.copyFile(null, testDirectoryName, "copiedFile.dat");
    }

    @Test
    public void testCopyFileFromInputStream() throws IOException {
        //Given
        String copyTo = testDirectoryName + File.separator + "copiedFile.dat";
        //When
        manager.copyFile(new FileInputStream(testFileName), testDirectoryName, "copiedFile.dat");
        //Then
        assertThat(new File(copyTo).exists(), is(true));
    }

    @Test
    public void emptySourceShouldThrowException() throws IllegalArgumentException, IOException {
        // Given
        String copyTo = testDirectoryName + File.separator + "copiedFile.dat";
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Source name must not be empty!");
        // When
        manager.moveFile("", copyTo);
    }

    @Test
    public void testMoveFile() throws IOException {
        String moveTo = testDirectoryName + File.separator + "newFile.dat";
        //When
        manager.moveFile(testFileName, moveTo);
        //Then
        assertThat(new File(moveTo).exists(), is(true));
        assertThat(new File(testFileName).exists(), is(false));
    }
}
