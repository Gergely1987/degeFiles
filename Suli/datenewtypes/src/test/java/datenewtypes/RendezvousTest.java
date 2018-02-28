//package datenewtypes;
//
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.ExpectedException;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//
//public class RendezvousTest {
//
//    @Rule
//    public final ExpectedException exception = ExpectedException.none();
//
//    @Test
//    public void emptyPatternShouldThrowException() throws IllegalArgumentException {
//        // Given
//        exception.expect(IllegalArgumentException.class);
//        exception.expectMessage("Empty pattern string");
//        // When
//        new Rendezvous("10:20", "");
//    }
//
//    @Test
//    public void emptyTimeStringShouldThrowException() throws IllegalArgumentException {
//        // Given
//        exception.expect(IllegalArgumentException.class);
//        exception.expectMessage("Illegal time string");
//        // When
//        new Rendezvous("", "hh:mm");
//    }
//
//    @Test
//    public void illegalTimeStringShouldThrowException() throws IllegalArgumentException {
//        // Given
//        exception.expect(IllegalArgumentException.class);
//        exception.expectMessage("Illegal time string");
//        // When
//        new Rendezvous("10:20:20", "hh:mm");
//    }
//
//    @Test
//    public void testToString() {
//        // Given
//        Rendezvous rendezvous = new Rendezvous(21, 30);
//        //Then
//        assertThat(rendezvous.toString("HH-mm"), equalTo("21-30"));
//    }
//
//    @Test
//    public void emptyPatternInToStringMethodShouldThrowException() throws IllegalArgumentException {
//        // Given
//        exception.expect(IllegalArgumentException.class);
//        exception.expectMessage("Empty pattern string");
//        // When
//        new Rendezvous("10:20", "HH:mm").toString("\t");
//    }
//
//    @Test
//    public void testCountMinutesLeft() {
//        // Given
//        Rendezvous rendezvous = new Rendezvous(22, 0);
//        //Then
//        assertThat(rendezvous.countMinutesLeft() > 0, is(true));
//    }
//
//    @Test
//    public void tooLateToGoShouldThrowException() throws MissedOpportunityException {
//        // Given
//        exception.expect(MissedOpportunityException.class);
//        exception.expectMessage("Too late!");
//        // When
//        new Rendezvous(10, 30).countMinutesLeft();
//    }
//
//    @Test
//    public void testPushLater() {
//        // Given
//        Rendezvous rendezvous = new Rendezvous(22, 0);
//        //When
//        rendezvous.pushLater(0, 90);
//        //Then
//        assertThat(rendezvous.toString("HH:mm"), equalTo("23:30"));
//    }
//
//    @Test
//    public void testPullEarlier() {
//        // Given
//        Rendezvous rendezvous = new Rendezvous(22, 0);
//        //When
//        rendezvous.pullEarlier(1, 15);
//        //Then
//        assertThat(rendezvous.toString("HH:mm"), equalTo("20:45"));
//    }
//}
