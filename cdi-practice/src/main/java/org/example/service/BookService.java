package org.example.service;

import org.example.NumberGenerator;
import org.example.ThirteenDigits;
import org.example.enity.Author;
import org.example.enity.Book;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionManager;
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
