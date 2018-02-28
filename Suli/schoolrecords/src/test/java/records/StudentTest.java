package records;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class StudentTest {

    public static final Tutor TUTOR = new Tutor("Nagy Lilla", new ArrayList<>());
    public static final Subject MATH = new Subject("matematika");

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void emptyNameShouldThrowException() throws IllegalArgumentException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Student name must not be empty!");
        // When
        new Student("");

    }

    @Test
    public void nullMarkInGradingShouldThrowException() throws NullPointerException {
        // Given
        exception.expect(NullPointerException.class);
        exception.expectMessage("Mark must not be null!");
        // When
        new Student("Kovács").grading(null);
    }

    @Test
    public void testGrading() {
        //Given
        Student student = new Student("Kovács");
        //When
        student.grading(new Mark(MarkType.A, MATH, TUTOR));
        //Then
        assertThat(student.toString(), equalTo("Kovács marks: matematika: excellent(5)"));
    }

    @Test
    public void testCalculateAverage() {
        //Given
        Student student = new Student("Kovács");
        //When
        student.grading(new Mark(MarkType.A, MATH, TUTOR));
        student.grading(new Mark(MarkType.C, MATH, TUTOR));
        student.grading(new Mark(MarkType.D, MATH, TUTOR));
        //Then
        assertThat(student.calculateAverage(), equalTo(3.33));
    }

    @Test
    public void testCalculateAverageIfMarksEmpty() {
        //Given
        Student student = new Student("Kovács");
        //Then
        assertThat(student.calculateAverage(), equalTo(0.0));
    }

    @Test
    public void testCalculateSubjectAverage() {
        //Given
        Student student = new Student("Kovács");
        //When
        student.grading(new Mark(MarkType.A, MATH, TUTOR));
        student.grading(new Mark(MarkType.C, new Subject("történelem"), TUTOR));
        student.grading(new Mark(MarkType.D, MATH, TUTOR));
        //Then
        assertThat(student.calculateSubjectAverage(MATH), equalTo(3.50));
    }

    @Test
    public void testCalculateSubjectAverageIfMarksEmpty() {
        //Given
        Student student = new Student("Kovács");
        //Then
        assertThat(student.calculateSubjectAverage(MATH), equalTo(0.0));
    }

    @Test
    public void testCalculateSubjectAverageIfNoMarkFromSubject() {
        //Given
        Student student = new Student("Kovács");
        //When
        student.grading(new Mark(MarkType.A, MATH, TUTOR));
        student.grading(new Mark(MarkType.C, new Subject("történelem"), TUTOR));
        student.grading(new Mark(MarkType.D, MATH, TUTOR));
        //Then
        assertThat(student.calculateSubjectAverage(new Subject("földrajz")), equalTo(0.0));
    }


}
