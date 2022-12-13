package org.example.ejb;

import org.example.entity.Book;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface BookEjbRemote {
     List<Book> findBooks();

     @NotNull Book createBook(@NotNull Book book) ;

     @NotNull Book updateBook(@NotNull Book book) ;

     void deleteBook(@NotNull Book book) ;
}
