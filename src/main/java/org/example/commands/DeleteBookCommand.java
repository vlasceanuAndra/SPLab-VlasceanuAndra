package org.example.commands;

import org.example.services.BooksService;

public class DeleteBookCommand implements Command {
    private final BooksService service;
    private final int id;

    public DeleteBookCommand(BooksService service, int id) {
        this.service = service;
        this.id = id;
    }

    @Override
    public Object execute() {
        return service.delete(id);
    }
}
