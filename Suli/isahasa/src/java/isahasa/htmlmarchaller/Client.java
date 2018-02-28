package isahasa.htmlmarchaller;

public class Client {

  private  Channel channel;

    public Client(Channel channel) {
        this.channel = channel;
    }
    public int writeToChannel(TextSource textSource) {

        String plainText = textSource.getPlainText();
        byte[] textByteArr = plainText.getBytes();

        return channel.writeByte(textByteArr);
    }

}
