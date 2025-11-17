package org.example.controllers;

import org.example.difexamples.ClientComponent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final ClientComponent client;

    public HelloController(ClientComponent client) {
        this.client = client;
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello from ClientComponent = " + client;
    }
}
