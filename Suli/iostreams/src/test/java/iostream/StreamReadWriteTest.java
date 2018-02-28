package iostream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StreamReadWriteTest {

    private File sourceFile;
    private File targetFile;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Rule
    public final TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        sourceFile = temporaryFolder.newFile();
        targetFile = temporaryFolder.newFile();
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sourceFile.getAbsoluteFile()), "UTF-8"))) {
            writer.write("árvíztűrő tükörfúrógép");
        }
    }

    @Test
    public void missingFileShouldThrowException() throws IllegalArgumentException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("File with given name cannot be found:");
        // When
        new StreamReadWrite().readUtfInput("data.dat", "UTF-8");

    }

    @Test
    public void testReadUtfInput() throws IOException {
        assertThat(new StreamReadWrite().readUtfInput(sourceFile.getCanonicalPath(), "UTF-8"), equalTo("árvíztűrő tükörfúrógép"));
        assertThat(new StreamReadWrite().readUtfInput(sourceFile.getCanonicalPath(), "ISO-8859-1").equals("árvíztűrő tükörfúrógép"), is(false));
    }

    @Test
    public void testWriteDataToOutputStream() {
        //Given
        double[] data = {10.45, 45.4, 55.12, 78.04};
        String fileName = targetFile.getAbsolutePath();
        //When
        new StreamReadWrite().writeDataToOutputStream(data, fileName);
        //Then
        assertThat(new File(fileName).length(), equalTo(32L));
    }

    @Test
    public void testReadDataFromInputStream() {
        //Given
        double[] data = {10.45, 45.4, 55.12, 78.04};
        String fileName = targetFile.getAbsolutePath();
        //When
        new StreamReadWrite().writeDataToOutputStream(data, fileName);
        List<Double> numbers = new StreamReadWrite().readDataFromInputStream(fileName);
        //Then
        assertThat(numbers.toString(), equalTo("[10.45, 45.4, 55.12, 78.04]"));
    }
}