//package xml.rss;
//
//import org.junit.Test;
//
//import java.util.Arrays;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.*;
//
//
//public class ChannelTest{
//
//
//    @Test
//    public void createChannelTest(){
//        Channel channel = new Channel("Yellowroad","yellowroad.hu","rttc",
//                Arrays.asList(new Item("Java","yellowroad.training360.com/java","best"))
//        );
//
//        assertThat(channel.getItems().size(), equalTo(1));
//        assertThat(channel.getItems().get(0).getTitle(), equalTo("Java"));
//        assertThat(channel.getTitle(), equalTo("Yellowroad"));
//        assertThat(channel.getDescription(), equalTo("rttc"));
//        assertThat(channel.getLink(), equalTo("yellowroad.hu"));
//    }
//
//}