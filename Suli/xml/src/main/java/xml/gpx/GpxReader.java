package xml.gpx;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class GpxReader {


    public List<TrackPoint> readTrack(InputStream input) {
        Document document;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();//ParserConfigurationException
            document = documentBuilder.parse(input);//SAXException

        } catch (ParserConfigurationException | SAXException | IOException ioe) {
            throw new IllegalArgumentException("Input is invalid", ioe);
        }
        NodeList nl = document.getElementsByTagName("trkpt");
        List<TrackPoint> trackPoints = new ArrayList<>();
        for (int i = 0; i < nl.getLength(); i++) {
            TrackPoint tp = new TrackPoint();
            tp.setLat(Double.parseDouble(((Element) nl.item(i)).getAttribute("lat")));
            tp.setLon(Double.parseDouble(((Element) nl.item(i)).getAttribute("lon")));
            tp.setElevation(Integer.parseInt(((Element) nl.item(i)).getElementsByTagName("ele").item(0).getTextContent()));
            String timeString = ((Element) nl.item(i)).getElementsByTagName("time").item(0).getTextContent();
            ZonedDateTime zd = ZonedDateTime.parse(timeString + "[UTC]");
            tp.setTime(zd);
            trackPoints.add(tp);

        }
        return trackPoints;
    }
}
