package job;

public class Job {
    private int priority;
    private String jobDescription;

    public Job(int priority, String jobDescription) {
       this.priority=priority;
        this.jobDescription = jobDescription;
    }

    public Job() {
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public int getPriority() {
        return priority;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public boolean isUrgent(){
        return priority<5;
    }



}
