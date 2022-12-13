package org.example.config;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DatabaseProducer {
    @Produces
    @PersistenceContext(unitName = "bookshelf")
    private EntityManager entityManager;
}
