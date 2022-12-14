package org.example.ejb;

import org.example.entity.Book;
import org.example.entity.Item;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.validation.constraints.NotNull;
import java.util.List;

@Stateless
public class ItemEjb implements ItemEjbRemote {
    @EJB
    private BookEJB bookEJB;
    @Resource
    SessionContext ctx;


   List<Book> findBooks() {

    }

    List<Item> findBCds() {

    }

    List<Book> findBookById(Long id) {

    }

    List<Item> findCdById(Long id) {

    }

    public @NotNull Book createBook(@NotNull Book book) {
       if(ctx.isCallerInRole("admin")) {
           return bookEJB.createBook(book);
       } else {
           return book;
       }
    }

    public void deleteBook(@NotNull Book book) {
        if(ctx.isCallerInRole("admin")) {
            bookEJB.deleteBook(book);
        }
    }
}
