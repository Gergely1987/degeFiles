package controliteration.guessthenumber;

import guessthenumber.PlayerWhoAnswers;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PlayerWhoAnswerTest {

    @Test
    public void shouldWellAnswer() {
        PlayerWhoAnswers playerWhoAnswers = new PlayerWhoAnswers(new Random(123), 100);
        // The random number is 82
        assertThat(playerWhoAnswers.answerTo(90), equalTo(Answer.LESS));
        assertThat(playerWhoAnswers.answerTo(82), equalTo(Answer.MATCH));
        assertThat(playerWhoAnswers.answerTo(50), equalTo(Answer.MORE));
    }
}
