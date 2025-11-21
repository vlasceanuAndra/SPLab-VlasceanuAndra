package org.example.services;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BooksService {

    private final Map<Integer, String> books = new HashMap<>();

    public List<String> getAll() {
        return new ArrayList<>(books.values());
    }

    public String get(int id) {
        return books.get(id);
    }

    public String create(String title) {
        int id = books.size() + 1;
        books.put(id, title);
        return "Created book with id " + id;
    }

    public String update(int id, String title) {
        books.put(id, title);
        return "Updated book " + id;
    }

    public String delete(int id) {
        books.remove(id);
        return "Deleted book " + id;
    }
}
