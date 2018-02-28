package collectionsautoboxing;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AutoboxingTest {

    @Test
    public void checkElementTypeInList() {
        //Given
        List<Integer> numbers = new Autoboxing().createList(2, 4, 6);
        //Then
        assertThat(numbers.size(), equalTo(3));
        assertThat(numbers.get(0), equalTo(2));
        assertThat(numbers.get(1), equalTo(4));
    }

    @Test
    public void checkSumValueInList() {
        //Given
        Autoboxing abox = new Autoboxing();
        //Then
        assertThat(abox.sumIntegerList(abox.createList(2, 4, 6)), equalTo(12));
    }

    @Test
    public void sumIntegerObjects() {
        assertThat(new Autoboxing().sumIntegerObjects(2, 4, 6), equalTo(12));
    }
}
