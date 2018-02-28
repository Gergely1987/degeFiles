package methodchain.trainer;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TrainerBuilderTest {

    @Test
    public void build() {
        Trainer trainer = new TrainerBuilder()
                .giveName("John Doe")
                .giveAge(30)
                .build();

        assertThat(trainer.getName(), equalTo("John Doe"));
        assertThat(trainer.getAge(), equalTo(30));
    }
}
