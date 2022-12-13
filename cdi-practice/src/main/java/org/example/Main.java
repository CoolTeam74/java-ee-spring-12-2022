package org.example;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.service.BookService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {
    public static void main(String[] args) {
        Weld weld =  new Weld();
        WeldContainer container = weld.initialize();
        BookService bookService = container.instance().select(BookService.class).get();
        Book book = bookService.createBook("title", 100.0,  new Author(), "description");
        System.out.println(book);
        weld.shutdown();
    }
}
