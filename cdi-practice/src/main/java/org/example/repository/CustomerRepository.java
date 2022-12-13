package org.example.repository;

import org.example.entity.Book;
import org.example.entity.Customer;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomerRepository {
    @Inject
    private EntityManager entityManager;

    public List<Customer> findByFirstNameAndSecondName(String firstName, String secondName) {
        TypedQuery<Customer> typedQuery = entityManager.createQuery(
                "select c from Customer c where c.firstName = :firstName and c.secondName=:secondName", Customer.class)
                .setParameter("firstName", firstName)
                .setParameter("secondName", secondName)
                .setMaxResults(1000);
        return typedQuery.getResultList();
    }


}
