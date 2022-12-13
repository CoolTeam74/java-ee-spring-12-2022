package org.example.repository;

import org.example.entity.Book;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BookRepository {
    @Inject
    private EntityManager entityManager;

    public List<Book> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> query = builder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    public List<Book> findByTitle(String title) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> query = builder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        query.select(root).where(builder.equal(root.get("title"), title));
        return entityManager.createQuery(query).getResultList();
    }

    public Book save(Book book) {
        entityManager.persist(book);
        return book;
    }

    public Book update(Book book) {
        entityManager.merge(book);
        return book;
    }


    public void delete(Book book) {
        entityManager.remove(book);
    }
}
