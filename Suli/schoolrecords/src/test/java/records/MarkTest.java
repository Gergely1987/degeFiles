package records;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MarkTest {

    public static final Tutor TUTOR = new Tutor("Nagy Lilla", new ArrayList<>());
    public static final Subject SUBJECT = new Subject("matematika");

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void nullParameterShouldThrowException() throws NullPointerException {
        // Given
        exception.expect(NullPointerException.class);
        exception.expectMessage("Both subject and tutor must be provided!");
        // When
        new Mark(MarkType.A, null, TUTOR);
    }

    @Test
    public void testCreate() {
        Mark mark = new Mark(MarkType.A, SUBJECT, TUTOR);
        assertThat(mark.getMarkType(), equalTo(MarkType.A));
        assertThat(mark.getSubject(), equalTo(SUBJECT));
        assertThat(mark.getTutor(), equalTo(TUTOR));
        assertThat(mark.toString(), equalTo("excellent(5)"));
    }
}
