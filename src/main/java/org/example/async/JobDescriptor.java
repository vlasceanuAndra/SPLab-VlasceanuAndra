package org.example.async;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.example.commands.Command;

@Getter
@Setter
public class JobDescriptor {
    private final String jobId;
    @JsonIgnore
    private final Command command;

    private JobStatus status = JobStatus.PENDING;
    private Object result;

    public JobDescriptor(String jobId, Command command) {
        this.jobId = jobId;
        this.command = command;
    }
}
