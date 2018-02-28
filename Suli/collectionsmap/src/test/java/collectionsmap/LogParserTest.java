package collectionsmap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class LogParserTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void faultyLogShouldThrowException() throws IOException {
        // Given
        String log = "invalid_log_format";

        exception.expect(IOException.class);
        exception.expectMessage("Incorrect log");

        // When
        new LogParser().parseLog(log);
    }

    @Test
    public void entriesWithSameIpShouldBeInSameList() throws IOException, ParseException {
        // Given
        String log = "176.121.45.124:2016-12-02:derzsi\n"
                +    "176.121.45.124:2016-12-03:ggrrrr\n";

        // When
        Map<String, List<Entry>> entries = new LogParser().parseLog(log);

        // Then
        assertThat(entries.size(), equalTo(1));
        assertThat(entries.get("176.121.45.124").size(), equalTo(2));
        assertThat(entries.get("176.121.45.124").get(0).getLogin(), equalTo("derzsi"));
        assertThat(entries.get("176.121.45.124").get(0).getIpAddress(), equalTo("176.121.45.124"));
        assertThat(entries.get("176.121.45.124").get(0).getEntryDate(), equalTo(
                new SimpleDateFormat("yyyy-MM-dd").parse("2016-12-02")));
    }
}
