package api.javaapi;

import java.net.MalformedURLException;
import java.net.URL;


public class UrlParser {

    public String readHost(String url) {
        URL host;
        try {
            host = new URL(url);
        } catch (MalformedURLException mfue) {
            throw new IllegalArgumentException("Invalid url: " + url);
        }
        return host.getHost();
    }

    public static void main(String[] args) {
        UrlParser up = new UrlParser();
        String url = "https://www.index.hu";
        System.out.println(up.readHost(url));
    }
}
