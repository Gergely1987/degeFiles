package fileclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FileManagerTest {

    public static final String[] EXTENSIONS = new String[]{".txt", ".dat", ".csv"};
    public FileManager manager;
    public String testDirectory;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        manager = new FileManager();
        testDirectory = folder.getRoot().getAbsolutePath();

        createDirectoryTree(testDirectory, 3, 2, "dir", 10, "testFile");
    }

    @After
    public void tearDown() {
        manager = null;
        testDirectory = null;
    }

    @Test
    public void testCreateFile() throws IOException {
        //When
        manager.createFile(testDirectory + File.separator + "testFile.txt");
        //Then
        assertThat(new File(testDirectory + File.separator + "testFile.txt").exists(), is(true));
    }

    @Test
    public void existingFileShouldThrowException() throws IllegalArgumentException, IOException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("File with this name already exists");
        // When
        manager.createFile(testDirectory + File.separator + "testFile.txt");
        manager.createFile(testDirectory + File.separator + "testFile.txt");
    }

    @Test
    public void testSubDirectory() throws IOException {
        //When
        manager.createSubDirectory(testDirectory, "testDir");
        //Then
        assertThat(new File(testDirectory, "testDir").exists(), is(true));
    }

    @Test
    public void existingDirectoryShouldThrowException() throws IllegalArgumentException, IOException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Directory with this name already exists");
        // When
        manager.createSubDirectory(testDirectory, "testDir");
        manager.createSubDirectory(testDirectory, "testDir");
    }

    @Test
    public void testDeleteFile() throws IOException {
        //Given
        manager.createFile(testDirectory + File.separator + "toBeDeleted");
        //Then
        assertThat(manager.deleteFile(testDirectory + File.separator + "toBeDeleted"), is(true));
    }

    @Test
    public void missingFileShouldThrowException() throws IllegalArgumentException, IOException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("File with this name does not exists");
        // When
        manager.deleteFile(testDirectory + File.separator + "toBeDeleted");
    }

    @Test
    public void testFindDirectories() throws IOException {
        //Given
        List<String> directories = new ArrayList<>();
        //When
        directories = manager.findDirectories(testDirectory, directories);
        //Then
        assertThat(directories.size(), equalTo(6));
    }

    @Test
    public void testListFilesByExtension() {
        //When
        List<String> fileList = manager.listFilesByExtension(testDirectory, "dat");
        //Then
        assertThat(fileList.get(0).endsWith(".dat"), is(true));
    }

    @Test
    public void nonexistentFileExtensionShouldThrowException() throws NullPointerException, IOException {
        // Given
        exception.expect(NullPointerException.class);
        exception.expectMessage("No files found with extension");
        // When
        manager.listFilesByExtension(testDirectory, "doc");
    }

    // ----------------- private methods to set up directory tree for testing ------------------

    private void createDirectoryTree(String currentPath, int depth, int dirCount, String dirName, int fileCount, String fileName) throws IOException {

        for (int j = 0; j < depth; j++) {
            currentPath = createFilesAndDirectories(currentPath, dirCount, dirName, fileCount, fileName);
        }
    }

    private String createFilesAndDirectories(String path, int dirCount, String dirName, int fileCount, String fileName) throws IOException {

        File currentDir = new File(path);
        currentDir.mkdir();
        for (int i = 0; i < dirCount; i++) {
            new File(path, dirName + i).mkdir();
        }
        for (int i = 0; i < fileCount; i++) {
            new File(path, fileName + i + selectExtension()).createNewFile();
        }
        File[] files = currentDir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                return file.getCanonicalPath();
            }
        }
        return path;
    }

    private String selectExtension() {
        Random rnd = new Random();
        return EXTENSIONS[rnd.nextInt(EXTENSIONS.length)];
    }
}
