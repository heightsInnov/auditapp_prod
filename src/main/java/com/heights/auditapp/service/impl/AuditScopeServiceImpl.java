package com.heights.auditapp.service.impl;

import com.heights.auditapp.dao.AuditScopeRepository;
import com.heights.auditapp.model.AuditScopeEntity;
import com.heights.auditapp.service.AuditScopeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
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
    public AuditScopeEntity save(AuditScopeEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<AuditScopeEntity> save(List<AuditScopeEntity> entities) {
        return (List<AuditScopeEntity>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(BigInteger id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AuditScopeEntity> findById(BigInteger id) {
        return repository.findById(id);
    }

    @Override
    public List<AuditScopeEntity> findAll() {
        return (List<AuditScopeEntity>) repository.findAll();
    }

    @Override
    public Page<AuditScopeEntity> findAll(Pageable pageable) {
        Page<AuditScopeEntity> entityPage = repository.findAll(pageable);
        List<AuditScopeEntity> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AuditScopeEntity update(AuditScopeEntity entity, BigInteger id) {
        Optional<AuditScopeEntity> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}