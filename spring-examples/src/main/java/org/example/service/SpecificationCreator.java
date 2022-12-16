package org.example.service;

import com.google.common.collect.Lists;
import lombok.experimental.UtilityClass;
import org.example.dto.AndFilter;
import org.example.dto.Filter;
import org.example.dto.OrFilter;
import org.example.dto.SearchCriteria;
import org.example.entity.Workspace;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import java.util.List;

@UtilityClass
public class SpecificationCreator {
    public Specification<Workspace> create(Filter filter) {
        if (filter instanceof OrFilter) {
            OrFilter orFilter = (OrFilter) filter;
            List<Specification<Workspace>> innerSpecifications = createInnerSpecifications(orFilter.getValue());
            return createOrSpecification(innerSpecifications);
        } else if (filter instanceof AndFilter) {
            return null;
        } else {
            SearchCriteria searchCriteria = (SearchCriteria) filter;
            return createSearchSpecification(searchCriteria);
        }
    }

    private Specification<Workspace> createSearchSpecification(SearchCriteria searchCriteria) {
        return new SearchSpecification(searchCriteria);
    }

    private Specification<Workspace> createOrSpecification(List<Specification<Workspace>> innerSpecifications) {
        Specification<Workspace> orSpecification =Specification.where(innerSpecifications.get(0));
        for (int i = 1; i < innerSpecifications.size(); i++) {
            orSpecification = innerSpecifications.get(i).or(orSpecification);
        }
        return orSpecification;
    }

    private List<Specification<Workspace>> createInnerSpecifications(List<Filter> value) {
        List<Specification<Workspace>> specs = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(value)) {
            value.forEach(f -> {
                Specification<Workspace> specification = create(f);
                specs.add(specification);
            });
        }
        return specs;
    }
}
