package org.example.async;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class JobStatusService {

    private final Map<String, JobDescriptor> jobs = new ConcurrentHashMap<>();

    public void addJob(JobDescriptor job) {
        jobs.put(job.getJobId(), job);
    }

    public JobDescriptor getJob(String id) {
        return jobs.get(id);
    }
}
