package org.example;

import javax.inject.Inject;

public class BookService {
    @Inject
    @ThirteenDigits
    private NumberGenerator generator;

    public Book createBook(String title, Double price, Author author, String description) {
        String id = generator.generateId();
        return new Book(title, description, author, id, price);
    }
}
