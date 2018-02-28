package methodargvars.trainer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TrainingTest {

    @Test
    public void testAddCourses() {
        Trainer trainer = new Trainer("John Doe");
        trainer.addCourses("Math", "Biology", "Art");

        assertThat(trainer.getCourses().size(), equalTo(3));
    }
}
