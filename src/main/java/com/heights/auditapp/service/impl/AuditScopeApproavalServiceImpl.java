package com.heights.auditapp.service.impl;

import com.heights.auditapp.dao.AuditScopeApproavalRepository;
import com.heights.auditapp.model.AuditScopeApproaval;
import com.heights.auditapp.service.AuditScopeApproavalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuditScopeApproavalServiceImpl implements AuditScopeApproavalService {
    private final AuditScopeApproavalRepository repository;

    public AuditScopeApproavalServiceImpl(AuditScopeApproavalRepository repository) {
        this.repository = repository;
    }

    @Override
    public AuditScopeApproaval save(AuditScopeApproaval entity) {
        return repository.save(entity);
    }

    @Override
    public List<AuditScopeApproaval> save(List<AuditScopeApproaval> entities) {
        return (List<AuditScopeApproaval>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AuditScopeApproaval> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AuditScopeApproaval> findAll() {
        return (List<AuditScopeApproaval>) repository.findAll();
    }

    @Override
    public Page<AuditScopeApproaval> findAll(Pageable pageable) {
        Page<AuditScopeApproaval> entityPage = repository.findAll(pageable);
        List<AuditScopeApproaval> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AuditScopeApproaval update(AuditScopeApproaval entity, Long id) {
        Optional<AuditScopeApproaval> optional = findById(id) );
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}