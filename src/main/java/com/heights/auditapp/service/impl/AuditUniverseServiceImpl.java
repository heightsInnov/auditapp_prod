package com.heights.auditapp.service.impl;

import com.heights.auditapp.dao.AuditUniverseRepository;
import com.heights.auditapp.model.AuditUniverseEntity;
import com.heights.auditapp.service.AuditUniverseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("AuditUniverseService")
@Transactional
public class AuditUniverseServiceImpl implements AuditUniverseService {
    private final AuditUniverseRepository repository;

    public AuditUniverseServiceImpl(AuditUniverseRepository repository) {
        this.repository = repository;
    }

    @Override
    public AuditUniverseEntity save(AuditUniverseEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<AuditUniverseEntity> save(List<AuditUniverseEntity> entities) {
        return (List<AuditUniverseEntity>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AuditUniverseEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AuditUniverseEntity> findAll() {
        return (List<AuditUniverseEntity>) repository.findAll();
    }

    @Override
    public Page<AuditUniverseEntity> findAll(Pageable pageable) {
        Page<AuditUniverseEntity> entityPage = repository.findAll(pageable);
        List<AuditUniverseEntity> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AuditUniverseEntity update(AuditUniverseEntity entity, Long id) {
        Optional<AuditUniverseEntity> optional = findById(id);
        if (optional.isPresent()) {
            optional.get().setAuthStat(entity.getAuthStat());
            optional.get().setRecordStat(entity.getRecordStat());
            optional.get().setUniverseName(entity.getUniverseName());
            return save(optional.get());
        }
        return null;
    }
}