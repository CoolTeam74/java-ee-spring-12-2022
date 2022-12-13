package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("B")
@NamedQueries({
                @NamedQuery(name= Book.FIND_ALL, query = "SELECT b FROM Book b"),
                @NamedQuery(name = "findBookSomeTitle", query = "SELECT b FROM Book b WHERE b.title = 'some'")
})
public class Book extends Item {
    public final static String FIND_ALL = "Book.findAll";

    @ManyToMany
    private List<Author> authors;

    private String isbn;

    private String publisher;
}
