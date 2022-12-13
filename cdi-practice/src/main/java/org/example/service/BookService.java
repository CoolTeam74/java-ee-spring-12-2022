package org.example.service;

import org.example.NumberGenerator;
import org.example.ThirteenDigits;
import org.example.entity.Author;
import org.example.entity.Book;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;

public class BookService {
    @Inject
    @ThirteenDigits
    private NumberGenerator generator;

    @PersistenceContext(unitName = "bookshelf")
    EntityManager entityManager;

    public Book createBook(String title, Double price, Author author, String description) {
        String id = generator.generateId();
        Book book = new Book(Arrays.asList(author), title, description);
        entityManager.persist(book);

        entityManager.flush();
        return book;
    }
}
