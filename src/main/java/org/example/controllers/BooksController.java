package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.async.*;
import org.example.commands.*;
import org.example.services.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final BooksService booksService;
    private final AsyncCommandExecutor executor;
    private final JobStatusService jobStatusService;

    @GetMapping
    public Object getAllBooks() {
        return new GetAllBooksCommand(booksService).execute();
    }

    @GetMapping("/{id}")
    public Object getBookById(@PathVariable int id) {
        return new GetBookByIdCommand(booksService, id).execute();
    }

    @PutMapping("/{id}")
    public Object updateBook(@PathVariable int id, @RequestBody String title) {
        return new UpdateBookCommand(booksService, id, title).execute();
    }

    @DeleteMapping("/{id}")
    public Object deleteBook(@PathVariable int id) {
        return new DeleteBookCommand(booksService, id).execute();
    }

    // ASYNC for POST
    @PostMapping
    public ResponseEntity<Object> createBook(@RequestBody String title) {

        String jobId = UUID.randomUUID().toString();

        CreateBookCommand cmd = new CreateBookCommand(booksService, title);
        JobDescriptor job = new JobDescriptor(jobId, cmd);

        jobStatusService.addJob(job);
        executor.submit(job);

        return ResponseEntity.accepted().body("Job accepted. ID = " + jobId);
    }
}
