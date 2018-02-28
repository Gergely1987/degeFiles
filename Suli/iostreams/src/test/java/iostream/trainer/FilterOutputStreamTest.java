package iostream.trainer;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class FilterOutputStreamTest {

    @Test
    public void testFilter() throws IOException {
        try (
                ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
                FilterOutputStream filterOutputStream = new FilterOutputStream(byteOutputStream)
        ) {
            filterOutputStream.write(1);
            assertThat(byteOutputStream.toByteArray(), equalTo(new byte[] {}));

            filterOutputStream.write(2);
            assertThat(byteOutputStream.toByteArray(), equalTo(new byte[] {2}));

            filterOutputStream.write(new byte[] {3, 4, 5, 6, 7, 8});
            assertThat(byteOutputStream.toByteArray(), equalTo(new byte[] {2, 4, 6, 8}));
        }
    }
}
