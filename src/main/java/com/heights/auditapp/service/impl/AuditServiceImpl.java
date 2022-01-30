package com.heights.auditapp.service.impl;

import com.heights.auditapp.dao.AuditRepository;
import com.heights.auditapp.model.AuditEntity;
import com.heights.auditapp.service.AuditService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuditServiceImpl implements AuditService {
    private final AuditRepository repository;

    public AuditServiceImpl(AuditRepository repository) {
        this.repository = repository;
    }

    @Override
    public AuditEntity save(AuditEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<AuditEntity> save(List<AuditEntity> entities) {
        return (List<AuditEntity>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AuditEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AuditEntity> findAll() {
        return (List<AuditEntity>) repository.findAll();
    }

    @Override
    public Page<AuditEntity> findAll(Pageable pageable) {
        Page<AuditEntity> entityPage = repository.findAll(pageable);
        List<AuditEntity> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AuditEntity update(AuditEntity entity, Long id) {
        Optional<AuditEntity> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}