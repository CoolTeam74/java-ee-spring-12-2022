package org.example;

import org.example.enity.Author;
import org.example.enity.Book;
import org.example.service.BookService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Assert;
import org.junit.Test;

public class BookServiceIT {
    @Test
    public void testCreateBook() {
        Weld weld =  new Weld();
        WeldContainer container = weld.initialize();
        BookService bookService = container.instance().select(BookService.class).get();
        Book book = bookService.createBook("title", 100.0,  new Author(), "description");
        Assert.assertTrue(book.getId().startsWith("MOCK"));
    }
}
