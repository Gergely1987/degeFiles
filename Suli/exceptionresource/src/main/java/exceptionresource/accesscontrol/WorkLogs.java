package exceptionresource.accesscontrol;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WorkLogs {
    private LocalDateTime ldt;
    private String userId;
    private InOut inOut;

    public LocalDateTime getLdt() {
        return ldt;
    }

    public String getUserId() {
        return userId;
    }

    public InOut getInOut() {
        return inOut;
    }

//    public WorkLogs(LocalDateTime ldt, String userId, InOut inOut) {
//        this.ldt = ldt;
//        this.userId = userId;
//        this.inOut = inOut;
//    }

    public WorkLogs(String time, String userId, String inOut) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm:ss");
        this.ldt = LocalDateTime.parse(time, formatter);
        this.userId = userId;
        this.inOut = InOut.valueOf(inOut);
    }
}
