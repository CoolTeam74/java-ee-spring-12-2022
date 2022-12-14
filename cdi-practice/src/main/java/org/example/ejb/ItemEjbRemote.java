package org.example.ejb;

import org.example.entity.Book;
import org.example.entity.Item;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface ItemEjbRemote {
    List<Book> findBooks() ;

    List<Item> findBCds() ;

    List<Book> findBookById(Long id) ;

    List<Item> findCdById(Long id) ;

    @NotNull Book createBook(@NotNull Book book);

    void deleteBook(@NotNull Book book);
}
