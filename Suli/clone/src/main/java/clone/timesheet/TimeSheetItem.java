package clone.timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeSheetItem {
    private String employee;
    private String project;
    private LocalDateTime from;
    private LocalDateTime to;

    public TimeSheetItem(TimeSheetItem tsi){
        employee=tsi.getEmployee();
        project=tsi.getProject();
        from=tsi.getFrom();
        to=tsi.getTo();
    }

    public TimeSheetItem() {
    }


    public static TimeSheetItem withDifferentDay(TimeSheetItem tsi, LocalDate ld){
        TimeSheetItem ts=new TimeSheetItem(tsi.employee,tsi.getProject(),
                LocalDateTime.of(ld.getYear(),ld.getMonthValue(),ld.getDayOfMonth(),tsi.from.getHour(),tsi.from.getMinute()),
                LocalDateTime.of(ld.getYear(),ld.getMonthValue(),ld.getDayOfMonth(),tsi.to.getHour(),tsi.to.getMinute()));

        return ts;
    }

    public TimeSheetItem(String employee, String project, LocalDateTime from, LocalDateTime to) {
        this.employee = employee;
        this.project = project;
        this.from = from;
        this.to = to;
    }

    public String getEmployee() {
        return employee;
    }

    public String getProject() {
        return project;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

}
