package org.example.async;

import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class AsyncCommandExecutor {

    private final BlockingQueue<JobDescriptor> queue = new LinkedBlockingQueue<>();

    public AsyncCommandExecutor(JobStatusService statusService) {

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(() -> {
            while (true) {
                JobDescriptor job = queue.take();
                try {
                    job.setStatus(JobStatus.RUNNING);
                    Object result = job.getCommand().execute();
                    job.setResult(result);
                    job.setStatus(JobStatus.DONE);

                } catch (Exception e) {
                    job.setStatus(JobStatus.ERROR);
                    e.printStackTrace();
                }
            }
        });
    }

    public void submit(JobDescriptor job) {
        queue.add(job);
    }
}
