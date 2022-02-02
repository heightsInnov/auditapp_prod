package com.heights.auditapp.service.impl;

import com.heights.auditapp.dao.AuditRepository;
import com.heights.auditapp.model.AuditEntity;
import com.heights.auditapp.service.AuditEntityService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuditEntityServiceImpl implements AuditEntityService {
    private final AuditRepository repository;

    public AuditEntityServiceImpl(AuditRepository repository) {
        this.repository = repository;
    }

    @Override
    public AuditEntity save(AuditEntity entity) {
        if(repository.existsByUniverseIdAndEntityName(entity.getUniverseId(), entity.getEntityName()))
            throw new DuplicateKeyException("Duplicate entity on audit universe");
        return repository.save(entity);
    }

    @Override
    public List<AuditEntity> save(List<AuditEntity> entities) {
        entities.forEach(x -> {
            if(repository.existsByUniverseIdAndEntityName(x.getUniverseId(), x.getEntityName()))
                throw new DuplicateKeyException("Duplicate entity on audit universe");
        });
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
            AuditEntity optionalEntity = optional.get();
            if (optionalEntity.getAuthStat() != null)
                optionalEntity.setAuthStat(entity.getAuthStat());
            if (optionalEntity.getRecordStat() != null)
                optionalEntity.setRecordStat(entity.getRecordStat());
            if (entity.getAuthStat() != null)
                optionalEntity.setAuthStat(optionalEntity.getAuthStat());
            if (entity.getEntityName() != null)
                optionalEntity.setEntityName(optionalEntity.getEntityName());
            if (entity.getUniverseId() != null)
                optionalEntity.setUniverseId(optionalEntity.getUniverseId());
            return save(optionalEntity);
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "No record found for entity");
    }

    @Override
    public List<AuditEntity> findEntitiesByUniverseId(Long universeId) {
        return repository.findAllByUniverseId(universeId);
    }

    @Override
    public boolean deleteByDtoId(Long dtoId) {
        return repository.deleteByEntityId(dtoId);
    }
}