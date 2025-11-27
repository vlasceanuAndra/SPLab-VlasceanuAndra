package org.example.controllers;

import org.example.observer.AllBooksSubject;
import org.example.observer.SseObserver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class BooksSseController {

    private final AllBooksSubject allBooksSubject;

    public BooksSseController(AllBooksSubject allBooksSubject) {
        this.allBooksSubject = allBooksSubject;
    }

    @RequestMapping("/books-sse")
    public SseEmitter getBooksSse() {
        System.out.println("--- CINEVA S-A CONECTAT LA SSE! ---");
        final SseEmitter emitter = new SseEmitter(0L); // 0L înseamnă timeout infinit
        allBooksSubject.attach(new SseObserver(emitter));
        return emitter;
    }
}