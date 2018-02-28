package collectionsmap;

import java.util.Date;

public class Entry {
    private String ipAddress;
    private Date entryDate;
    private String login;


    public Entry(String ipAddress, Date entryDate, String login) {
        this.ipAddress = ipAddress;
        this.entryDate = entryDate;
        this.login = login;
    }

    public Entry() {
    }

    public String getLogin() {
        return login;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Date getEntryDate() {
        return entryDate;
    }
}
