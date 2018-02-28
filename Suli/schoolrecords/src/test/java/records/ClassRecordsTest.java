//package records;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.ExpectedException;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//
//public class ClassRecordsTest {
//
//    private ClassRecords classRecords;
//    private Tutor tutor = new Tutor("Nagy Csilla", new ArrayList<>());
//
//    @Rule
//    public final ExpectedException exception = ExpectedException.none();
//
//    @Before
//    public void setUp() {
//        classRecords = new ClassRecords("Fourth Grade A", new Random(5));
//        Student firstStudent = new Student("Kovács Rita");
//        Student secondStudent = new Student("Nagy Béla");
//        Student thirdStudent = new Student("Varga Márton");
//        firstStudent.grading(new Mark(MarkType.A, new Subject("földrajz"), tutor));
//        firstStudent.grading(new Mark(MarkType.C, new Subject("matematika"), tutor));
//        firstStudent.grading(new Mark(MarkType.D, new Subject("földrajz"), tutor));
//        secondStudent.grading(new Mark(MarkType.A, new Subject("biológia"), tutor));
//        secondStudent.grading(new Mark(MarkType.C, new Subject("matematika"), tutor));
//        secondStudent.grading(new Mark(MarkType.D, new Subject("zene"), tutor));
//        thirdStudent.grading(new Mark(MarkType.A, new Subject("fizika"), tutor));
//        thirdStudent.grading(new Mark(MarkType.C, new Subject("kémia"), tutor));
//        thirdStudent.grading(new Mark(MarkType.D, new Subject("földrajz"), tutor));
//        classRecords.addStudent(firstStudent);
//        classRecords.addStudent(secondStudent);
//        classRecords.addStudent(thirdStudent);
//    }
//
//    @After
//    public void tearDown() {
//        classRecords = null;
//    }
//
//    @Test
//    public void testCreate() {
//        assertThat(classRecords.getClassName(), equalTo("Fourth Grade A"));
//    }
//
//    @Test
//    public void testAddStudentAlreadyExists() {
//        assertThat(classRecords.addStudent(new Student("Nagy Béla")), is(false));
//    }
//
//    @Test
//    public void testAddStudent() {
//        assertThat(classRecords.addStudent(new Student("Nagy Klára")), is(true));
//    }
//
//    @Test
//    public void testRemoveStudent() {
//        assertThat(classRecords.removeStudent(new Student("Nagy Béla")), is(true));
//    }
//
//    @Test
//    public void testRemoveStudentDoesNotExists() {
//        assertThat(classRecords.removeStudent(new Student("Nagy Klára")), is(false));
//    }
//
//    @Test
//    public void emptyStudentListShouldThrowException() throws ArithmeticException {
//        // Given
//        exception.expect(ArithmeticException.class);
//        exception.expectMessage("No student in the class");
//        // When
//        new ClassRecords("First Grade", new Random()).calculateClassAverage();
//    }
//
//    @Test
//    public void noMarksShouldThrowException() throws ArithmeticException {
//        // Given
//        exception.expect(ArithmeticException.class);
//        exception.expectMessage("No marks present");
//        ClassRecords classRecords = new ClassRecords("First Grade", new Random());
//        classRecords.addStudent(new Student("Nagy Béla"));
//        // When
//        classRecords.calculateClassAverage();
//    }
//
//    @Test
//    public void testCalculateClassAverage() {
//        assertThat(classRecords.calculateClassAverage(), equalTo(3.33));
//    }
//
//    @Test
//    public void testCalculateClassAverageBySubject() {
//        //Given
//        Subject geography = new Subject("földrajz");
//        //Then
//        assertThat(classRecords.calculateClassAverageBySubject(geography), equalTo(2.75));
//    }
//
//    @Test
//    public void emptyStudentNameShouldThrowException() throws IllegalArgumentException {
//        // Given
//        exception.expect(IllegalArgumentException.class);
//        exception.expectMessage("Student name must not be empty!");
//        // When
//        classRecords.findStudentByName("");
//    }
//
//    @Test
//    public void emptyListShouldThrowException() throws IllegalStateException {
//        // Given
//        exception.expect(IllegalStateException.class);
//        exception.expectMessage("No students to search!");
//        // When
//        new ClassRecords("First Grade", new Random()).findStudentByName("Kovács Rita");
//    }
//
//    @Test
//    public void nonExistingStudentShouldThrowException() throws IllegalArgumentException {
//        // Given
//        exception.expect(IllegalArgumentException.class);
//        exception.expectMessage("Student by this name cannot be found!");
//        // When
//        classRecords.findStudentByName("Kiss Rita");
//    }
//
//    @Test
//    public void testFindStudentByName() {
//        assertThat(classRecords.findStudentByName("Kovács Rita").getName(), equalTo("Kovács Rita"));
//    }
//
//    @Test
//    public void emptyListException() throws IllegalStateException {
//        // Given
//        exception.expect(IllegalStateException.class);
//        exception.expectMessage("No students to select for repetition!");
//        // When
//        new ClassRecords("Fourth Grade", new Random()).repetition();
//    }
//
//    @Test
//    public void testRepetition() {
//        assertThat(classRecords.repetition().getName(), equalTo("Varga Márton"));
//    }
//
//    @Test
//    public void emptyListThrowsException() throws IllegalStateException {
//        // Given
//        exception.expect(IllegalStateException.class);
//        exception.expectMessage("No students to list results!");
//        // When
//        new ClassRecords("Fourth Grade", new Random()).listStudyResults();
//    }
//
//    @Test
//    public void testListStudyResults() {
//        //Given
//        List<StudyResultByName> list = classRecords.listStudyResults();
//        //Then
//        assertThat(list.get(0).getStudentName(), equalTo("Kovács Rita"));
//        assertThat(list.get(0).getStudyAverage(), equalTo(3.33));
//        assertThat(list.size(), equalTo(3));
//    }
//
//    @Test
//    public void testListStudentNames() {
//        assertThat(classRecords.listStudentNames(), equalTo("Kovács Rita, Nagy Béla, Varga Márton"));
//    }
//}
