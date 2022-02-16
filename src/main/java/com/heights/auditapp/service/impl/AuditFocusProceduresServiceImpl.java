package com.heights.auditapp.service.impl;

import com.heights.auditapp.dao.AuditFocusProceduresRepository;
import com.heights.auditapp.model.AuditFocusProcedures;
import com.heights.auditapp.model.ControllerRaise;
import com.heights.auditapp.service.AuditFocusProceduresService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuditFocusProceduresServiceImpl implements AuditFocusProceduresService {
    private final AuditFocusProceduresRepository repository;
    private final EntityManager entityManager;

    public AuditFocusProceduresServiceImpl(AuditFocusProceduresRepository repository, EntityManager entityManager) {
        this.repository = repository;
        this.entityManager = entityManager;
    }

    @Override
    public AuditFocusProcedures save(AuditFocusProcedures entity) {
        return repository.save(entity);
    }

    @Override
    public List<AuditFocusProcedures> save(List<AuditFocusProcedures> entities) {
        return (List<AuditFocusProcedures>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AuditFocusProcedures> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AuditFocusProcedures> findAll() {
        return (List<AuditFocusProcedures>) repository.findAll();
    }

    @Override
    public Page<AuditFocusProcedures> findAll(Pageable pageable) {
        Page<AuditFocusProcedures> entityPage = repository.findAll(pageable);
        List<AuditFocusProcedures> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AuditFocusProcedures update(AuditFocusProcedures entity, Long id) {
        Optional<AuditFocusProcedures> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }

    @Override
    public List<ControllerRaise> getExceptions() {
        return entityManager
                .createNamedQuery("getProcessExceptions",
                        ControllerRaise.class)
                .getResultList();
    }
}