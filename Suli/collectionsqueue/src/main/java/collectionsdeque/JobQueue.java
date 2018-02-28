package collectionsdeque;

import job.Job;
import job.NoJobException;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class JobQueue {

    public Deque<Job> addJobByUrgency(Job... jobs) {
        Deque<Job> allJobs = new ArrayDeque<>();
        for (Job j : jobs) {
            allJobs.add(j);
        }
        return allJobs;
    }

    public Job dispatchUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()) {
            throw new NoJobException("No job available");
        }

        Job urgentJob = new Job();
        for (Job j : jobs) {
            if (j.isUrgent()) {
                urgentJob = j;
            }
        }
        return urgentJob;
    }

    public Job dispatchNotUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()) {
            throw new NoJobException("No job available");
        }
        Job notUrgentJob = new Job();
        for (Job j : jobs) {
            if (!j.isUrgent()) {
                notUrgentJob = j;
            }
        }
        return notUrgentJob;
    }

}
