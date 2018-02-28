//package xml.rss;
//
//import org.junit.Test;
//
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.junit.Assert.*;
//
//
//public class RssReaderTest {
//
//    @Test
//    public void readRssTest() throws IOException {
//
//        try (
//                InputStream is = RssReaderTest.class.getResourceAsStream("/example.rss");
//        ) {
//            Channel channel = new RssReader().readRss(is);
//
//
//            assertThat(channel.getItems().size(), equalTo(4));
//            assertThat(channel.getTitle(), equalTo("Example"));
//            assertThat(channel.getLink(), equalTo("yellowroad.training360.com"));
//            assertThat(channel.getDescription(), equalTo("Right trip to coding"));
//            assertThat(channel.getItems().get(2).getTitle(), equalTo("Java"));
//            assertThat(channel.getItems().get(3).getLink(), equalTo("http://yellowroad.training360.com/lesson/php"));
//            assertThat(channel.getItems().get(1).getDescription(), equalTo("You can learn everything about Frontend"));
//
//
//        }
//    }
//}