package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.Operation;
import org.example.dto.SearchCriteria;
import org.example.entity.Workspace;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RequiredArgsConstructor
public class SearchSpecification implements Specification<Workspace> {
    private final SearchCriteria searchCriteria;

    @Override
    public Predicate toPredicate(Root<Workspace> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Join<Object, Object> join = null;
        if (searchCriteria.getTable() != null) {
            join = root.join(searchCriteria.getTable());
        }

        if (Operation.GR.getAlias().equalsIgnoreCase(searchCriteria.getOperator())) {
            return criteriaBuilder.greaterThan(root.<String>get(searchCriteria.getKey()), searchCriteria.getValue().toString());
        } else if (Operation.EQ.getAlias().equalsIgnoreCase(searchCriteria.getOperator())) {
            if (searchCriteria.getTable() != null) {
                return criteriaBuilder.equal(join.get(searchCriteria.getKey()), searchCriteria.getValue());
            } else {
                criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
            }
        }

        return null;
    }
}
