package org.example.config;


import org.example.ejb.BookEJB;
import org.example.entity.Author;
import org.example.entity.Book;

import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.Arrays;

@Singleton
@Startup
@DataSourceDefinition(
        className = "org.h2.jdbc.EmbeddableDataSource",
        name = "java:/global/jdbc/bookshelf",
        user = "sa",
        password = "",
        databaseName = "bookshelf"
)
public class DbPopulator {
    @Inject
    private BookEJB bookEJB;

    private Book book1;

    @PostConstruct
    public void createDB() {
        book1 = new Book(Arrays.asList(new Author()), "ISBN-12345-67890", "test");
        bookEJB.createBook(book1);
    }

    public void clearDB() {
        bookEJB.deleteBook(book1);
    }
}
