package org.example.commands;

import org.example.services.BooksService;

public class GetAllBooksCommand implements Command {
    private final BooksService service;

    public GetAllBooksCommand(BooksService service) {
        this.service = service;
    }

    @Override
    public Object execute() {
        return service.getAll();
    }
}