package org.example.commands;

import org.example.services.BooksService;

public class UpdateBookCommand implements Command {
    private final BooksService service;
    private final Long id;
    private final String title;

    public UpdateBookCommand(BooksService service, Long id, String title) {
        this.service = service;
        this.id = id;
        this.title = title;
    }

    @Override
    public Object execute() {
        return service.update(id, title);
    }
}