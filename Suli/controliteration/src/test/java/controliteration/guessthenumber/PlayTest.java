package controliteration.guessthenumber;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PlayTest {

    @Test
    public void shouldFindTheNumber() {
        Random random = new Random(123);
        // The random number is 82
        PlayerWhoAsks playerWhoAsks = new PlayerWhoAsks();
        List<Integer> numbers = playerWhoAsks.play(random);
        assertThat(numbers, equalTo(Arrays.asList(50, 75, 87, 81, 84, 82)));
    }

}
