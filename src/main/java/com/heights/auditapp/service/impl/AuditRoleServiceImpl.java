package com.heights.auditapp.service.impl;

import com.heights.auditapp.dao.AuditRoleRepository;
import com.heights.auditapp.model.AuditRole;
import com.heights.auditapp.service.AuditRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuditRoleServiceImpl implements AuditRoleService {
    private final AuditRoleRepository repository;

    public AuditRoleServiceImpl(AuditRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public AuditRole save(AuditRole entity) {
        return repository.save(entity);
    }

    @Override
    public List<AuditRole> save(List<AuditRole> entities) {
        return (List<AuditRole>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AuditRole> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AuditRole> findAll() {
        return (List<AuditRole>) repository.findAll();
    }

    @Override
    public Page<AuditRole> findAll(Pageable pageable) {
        Page<AuditRole> entityPage = repository.findAll(pageable);
        List<AuditRole> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AuditRole update(AuditRole entity, Long id) {
        Optional<AuditRole> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}