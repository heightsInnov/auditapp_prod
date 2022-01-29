package com.heights.auditapp.service.impl;

import com.heights.auditapp.dao.AuditEntityRepository;
import com.heights.auditapp.model.AuditEntityEntity;
import com.heights.auditapp.service.AuditEntityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuditEntityServiceImpl implements AuditEntityService {
    private final AuditEntityRepository repository;

    public AuditEntityServiceImpl(AuditEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public AuditEntityEntity save(AuditEntityEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<AuditEntityEntity> save(List<AuditEntityEntity> entities) {
        return (List<AuditEntityEntity>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AuditEntityEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AuditEntityEntity> findAll() {
        return (List<AuditEntityEntity>) repository.findAll();
    }

    @Override
    public Page<AuditEntityEntity> findAll(Pageable pageable) {
        Page<AuditEntityEntity> entityPage = repository.findAll(pageable);
        List<AuditEntityEntity> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AuditEntityEntity update(AuditEntityEntity entity, Long id) {
        Optional<AuditEntityEntity> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }

    @Override
    public List<AuditEntityEntity> findEntitiesByUniverseId(Long universeId) {
        return findEntitiesByUniverseId(universeId);
    }
}