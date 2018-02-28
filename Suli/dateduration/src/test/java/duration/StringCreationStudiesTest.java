package duration;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringCreationStudiesTest {

    @Test
    public void testStringObjectCreationTime() {
        // Given
        int objectsCount = 1_000_000;
        StringCreationStudies scs = new StringCreationStudies();
        //Then
        assertThat((scs.measureStringCreationTimeRequiredOnHeap(objectsCount) > scs.measureStringCreationTimeRequiredInPool(objectsCount)), is(true));
    }
}
