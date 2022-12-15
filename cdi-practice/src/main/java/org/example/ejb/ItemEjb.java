package org.example.ejb;

import org.example.entity.Book;
import org.example.entity.Item;
import org.example.ws.CardValidator;
import org.example.ws.Validator;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.validation.constraints.NotNull;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.soap.Addressing;
import java.util.List;

@Stateless
public class ItemEjb implements ItemEjbRemote {
    @EJB
    private BookEJB bookEJB;
    @Resource
    private SessionContext ctx;

    @WebServiceRef
    private Validator cardValidator;


   public List<Book> findBooks() {
       return null;
    }

    public List<Item> findBCds() {
        return null;
    }

    public List<Book> findBookById(Long id) {
        return null;
    }

    public List<Item> findCdById(Long id) {
        return null;
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
