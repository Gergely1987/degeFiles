package exam;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TrackPointTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void parseInvalid() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid field number");
        new TrackPoint("abc,abc");
    }

    @Test
    public void parse() {
        TrackPoint trackPoint = new TrackPoint("2017-01-01,14:00,3.56,3.68,400,Hello World!");
        assertThat(trackPoint.getTime(), equalTo(LocalDateTime.of(2017, 1, 1, 14, 0)));
        assertThat(trackPoint.getLat(), equalTo(3.56));
        assertThat(trackPoint.getLon(), equalTo(3.68));
        assertThat(trackPoint.getElevation(), equalTo(400));
        assertThat(trackPoint.getComment(), equalTo("Hello World!"));
    }
}
