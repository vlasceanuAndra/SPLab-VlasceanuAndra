package org.example.commands;

import org.example.services.BooksService;

public class CreateBookCommand implements Command {
    private final BooksService service;
    private final String title;

    public CreateBookCommand(BooksService service, String title) {
        this.service = service;
        this.title = title;
    }

    @Override
    public Object execute() {
        return service.create(title);
    }
}
