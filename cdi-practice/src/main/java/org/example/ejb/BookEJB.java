package org.example.ejb;

import org.example.entity.Book;
import org.example.repository.BookRepository;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.util.List;

public class BookEJB implements BookEjbRemote {
    @Inject
    private BookRepository bookRepository;

    public List<Book> findBooks() {
        return bookRepository.findAll();
    }

    public @NotNull Book createBook(@NotNull Book book) {
        return bookRepository.save(book);
    }

    public @NotNull Book updateBook(@NotNull Book book) {
        return bookRepository.update(book);
    }

    public void deleteBook(@NotNull Book book) {
        bookRepository.delete(book);
    }
}
