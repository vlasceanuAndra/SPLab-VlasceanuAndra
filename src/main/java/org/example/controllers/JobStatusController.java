package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.async.JobDescriptor;
import org.example.async.JobStatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobStatusController {

    private final JobStatusService jobStatusService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getStatus(@PathVariable String id) {

        JobDescriptor job = jobStatusService.getJob(id);

        if (job == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(job);
    }
}
