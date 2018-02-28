package xml.gpx;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GpxReaderTest {
    @Test
    public void testReadGpx() throws IOException {
        try (
                InputStream is = GpxReaderTest.class.getResourceAsStream("/track.gpx");
                )
        {
            List<TrackPoint> track = new GpxReader().readTrack(is);

            assertThat(track.size(), equalTo(7));
            assertThat(track.get(0).getLat(), equalTo(46.57608333));
            assertThat(track.get(1).getLon(), equalTo(8.89252778));
            assertThat(track.get(2).getElevation(), equalTo(2372));
            assertThat(track.get(3).getTime(), equalTo(ZonedDateTime.of(2007, 10, 14, 10, 13, 12, 0,ZoneId.of("UTC"))));
        }
    }
}
