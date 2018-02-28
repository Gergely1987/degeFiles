package collectionsmap;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser {


    public Map<String, List<Entry>> parseLog(String log) throws IOException {
        Map<String, List<Entry>> logs = new HashMap<>();
        List<Entry> entries = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new StringReader(log));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("alma");
                String ipAddress = line.split(":")[0];
                String login = line.split(":")[2];
                Date entryDate;
                try {
                    entryDate = new SimpleDateFormat("yyyy-MM-dd").parse(line.split(":")[1]);
                } catch (ParseException p) {
                    throw new IllegalArgumentException("Invalid date format!", p);
                }

                entries.add(new Entry(ipAddress, entryDate, login));
                logs.put(ipAddress, entries);

            }


        } catch (FileNotFoundException e) {
            throw new IOException("Incorrect log");
        } catch (IOException e) {
            throw new IOException("Incorrect log");
        }
        return logs;
    }


}
