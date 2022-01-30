package com.heights.auditapp.service.impl;

import com.heights.auditapp.dao.AuditScopeRepository;
import com.heights.auditapp.model.AuditScope;
import com.heights.auditapp.service.AuditScopeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuditScopeServiceImpl implements AuditScopeService {
    private final AuditScopeRepository repository;

    public AuditScopeServiceImpl(AuditScopeRepository repository) {
        this.repository = repository;
    }

    @Override
    public AuditScope save(AuditScope auditScope) {
        return repository.save(auditScope);
    }

    @Override
    public List<AuditScope> save(List<AuditScope> entities) {
        return (List<AuditScope>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AuditScope> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AuditScope> findAll() {
        return (List<AuditScope>) repository.findAll();
    }

    @Override
    public Page<AuditScope> findAll(Pageable pageable) {
        Page<AuditScope> Page = repository.findAll(pageable);
        List<AuditScope> entities = Page.getContent();
        return new PageImpl<>(entities, pageable, Page.getTotalElements());
    }

    @Override
    public AuditScope update(AuditScope auditScope, Long id) {
        Optional<AuditScope> optional = findById(id);
        if (optional.isPresent()) {
            return save(auditScope);
        }
        return null;
    }
}