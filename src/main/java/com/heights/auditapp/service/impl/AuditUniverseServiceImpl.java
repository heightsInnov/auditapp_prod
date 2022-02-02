package com.heights.auditapp.service.impl;

import com.heights.auditapp.dao.AuditUniverseRepository;
import com.heights.auditapp.model.AuditUniverse;
import com.heights.auditapp.service.AuditUniverseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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
    public AuditUniverse save(AuditUniverse entity) {
        return repository.save(entity);
    }

    @Override
    public List<AuditUniverse> save(List<AuditUniverse> entities) {
        return (List<AuditUniverse>) repository.saveAll(entities);
    }

    @Override
    public boolean deleteById(Long id) {
        return repository.deleteByUniverseId(id);
    }

    @Override
    public Optional<AuditUniverse> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AuditUniverse> findAll() {
        return (List<AuditUniverse>) repository.findAll();
    }

    @Override
    public Page<AuditUniverse> findAll(Pageable pageable) {
        Page<AuditUniverse> entityPage = repository.findAll(pageable);
        List<AuditUniverse> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AuditUniverse update(AuditUniverse entity, Long id) {
        Optional<AuditUniverse> optional = findById(id);
        if (optional.isPresent()) {
            AuditUniverse universe = optional.get();
            if (universe.getAuthStat() != null)
                universe.setAuthStat(entity.getAuthStat());
            if (universe.getRecordStat() != null)
                universe.setRecordStat(entity.getRecordStat());
            if(universe.getUniverseName() != null)
                universe.setUniverseName(entity.getUniverseName());
            return save(universe);
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "No record found for entity");
    }

    @Override
    public boolean deleteByDtoId(Long dtoId) {
        return repository.deleteByUniverseId(dtoId);
    }
}