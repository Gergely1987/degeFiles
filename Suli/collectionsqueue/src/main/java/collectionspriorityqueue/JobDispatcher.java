package collectionspriorityqueue;

import job.Job;
import job.NoJobException;

import java.util.*;

public class JobDispatcher {
    Queue<Job> newJobs = new PriorityQueue<>(new Comparator<Job>() {
        @Override
        public int compare(Job o1, Job o2) {
            return o1.getPriority()-o2.getPriority();
        }
    });

    public Queue<Job> addJob(Job... jobs) {
        for (Job j : jobs) {
            newJobs.add(j);
        }
        return newJobs;
    }

    public Job dispatchNextJob(Queue<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()) {
            throw new NoJobException("No job available");
        }
        return jobs.element();
    }
}
