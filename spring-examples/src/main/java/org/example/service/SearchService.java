package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.Filter;
import org.example.dto.ResultDto;
import org.example.entity.Workspace;
import org.example.repository.WorkspaceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final WorkspaceRepository repository;

    public ResultDto search(Filter filter) {
        Pageable pageable = Pageable.unpaged();
        Specification<Workspace> specification = SpecificationCreator.create(filter); // TODO: parametrize and make more generic
        Page<Workspace> results = repository.findAll(specification, pageable);
        return new ResultDto();
    }
}
