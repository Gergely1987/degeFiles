//package xml.rss;
//
//import org.junit.Test;
//import org.w3c.dom.Document;
//
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.TransformerException;
//
//import java.util.Arrays;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.junit.Assert.*;
//
//public class RssWriterTest {
//
//    RssWriter rssWriter = new RssWriter();
//
//    @Test
//    public void createDocumentTest() throws TransformerException, ParserConfigurationException {
//        Channel channel = new Channel("Yellowroad","yellowroad.hu","rttc",
//                Arrays.asList(new Item("Java","yellowroad.training360.com/java","best"))
//        );
//
//        Document document = rssWriter.createDocumentByChannel(channel);
//
//        assertThat(document.getElementsByTagName("channel").getLength(), equalTo(1));
//        assertThat(document.getElementsByTagName("title").getLength(), equalTo(2));
//        assertThat(document.getElementsByTagName("link").item(0).getTextContent(), equalTo("yellowroad.hu"));
//        assertThat(document.getElementsByTagName("description").item(1).getTextContent(), equalTo("best"));
//
//    }
//
//
//    @Test
//    public void writeRssTest(){
//        Channel channel = new Channel("Yellowroad","yellowroad.hu","rttc",
//                Arrays.asList(new Item("Java","yellowroad.training360.com/java","best"))
//        );
//
//        assertThat(rssWriter.writeRss(channel), equalTo("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" +
//                "<rss>" +
//                 "<channel>" +
//                   "<title>Yellowroad</title>" +
//                   "<link>yellowroad.hu</link>" +
//                   "<description>rttc</description>" +
//                   "<item>" +
//                    "<title>Java</title>" +
//                    "<link>yellowroad.training360.com/java</link>" +
//                    "<description>best</description>" +
//                   "</item>" +
//                 "</channel>" +
//                "</rss>"));
//
//    }
//
//}