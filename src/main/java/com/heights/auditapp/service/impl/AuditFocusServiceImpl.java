package com.heights.auditapp.service.impl;

import com.heights.auditapp.dao.AuditFocusRepository;
import com.heights.auditapp.model.AuditFocus;
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
    public AuditFocus save(AuditFocus entity) {
        return repository.save(entity);
    }

    @Override
    public List<AuditFocus> save(List<AuditFocus> entities) {
        return (List<AuditFocus>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AuditFocus> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AuditFocus> findAll() {
        return (List<AuditFocus>) repository.findAll();
    }

    @Override
    public Page<AuditFocus> findAll(Pageable pageable) {
        Page<AuditFocus> entityPage = repository.findAll(pageable);
        List<AuditFocus> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AuditFocus update(AuditFocus entity, Long id) {
        Optional<AuditFocus> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}