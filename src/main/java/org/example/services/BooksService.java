package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.observer.AllBooksSubject;
import org.example.persistence.BooksRepository;
import org.example.splaborator.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BooksService {

    private final BooksRepository booksRepository;
    private final AllBooksSubject allBooksSubject;
    public List<Book> getAll() {
        return booksRepository.findAll();
    }

    public Book get(Long id) {
        return booksRepository.findById(id).orElse(null);
    }

    public Book create(String title) {
        Book book = new Book(title);
        Book savedBook = booksRepository.save(book);
        System.out.println("--- CARTE SALVATA, ACUM NOTIFIC... ---");
        allBooksSubject.add(savedBook);
        return savedBook;
    }

    public Book update(Long id, String title) {
        Optional<Book> bookOptional = booksRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setTitle(title);
            booksRepository.save(book);
            return book;
        }
        return null;
    }

    public String delete(Long id) {
        if (booksRepository.existsById(id)) {
            booksRepository.deleteById(id);
            return "Deleted book " + id;
        }
        return "Book not found " + id;
    }
}