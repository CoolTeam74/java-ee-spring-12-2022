package org.example;

import org.example.ejb.BookEjbRemote;
import org.example.entity.Book;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;

public class MainClient {
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        BookEjbRemote bookEjbRemote = (BookEjbRemote) ctx.lookup("java:/global/bookshelf-1.0/BookEJB/org.example.ejb.BookEjbRemote");
        List<Book> books = bookEjbRemote.findBooks();

        // create Book book = new Book();
        // bookEjbRemote.addBook(book);
    }
}
