package com.heights.auditapp.service.impl;

import com.heights.auditapp.dao.AuditFocusRepository;
import com.heights.auditapp.model.AuditFocusEntity;
import com.heights.auditapp.service.AuditFocusService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuditFocusServiceImpl implements AuditFocusService {
    private final AuditFocusRepository repository;

    public AuditFocusServiceImpl(AuditFocusRepository repository) {
        this.repository = repository;
    }

    @Override
    public AuditFocusEntity save(AuditFocusEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<AuditFocusEntity> save(List<AuditFocusEntity> entities) {
        return (List<AuditFocusEntity>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AuditFocusEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AuditFocusEntity> findAll() {
        return (List<AuditFocusEntity>) repository.findAll();
    }

    @Override
    public Page<AuditFocusEntity> findAll(Pageable pageable) {
        Page<AuditFocusEntity> entityPage = repository.findAll(pageable);
        List<AuditFocusEntity> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AuditFocusEntity update(AuditFocusEntity entity, Long id) {
        Optional<AuditFocusEntity> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}