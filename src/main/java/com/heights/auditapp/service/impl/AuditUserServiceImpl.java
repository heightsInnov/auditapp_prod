package com.heights.auditapp.service.impl;

import com.heights.auditapp.dao.AuditUserRepository;
import com.heights.auditapp.model.AuditUser;
import com.heights.auditapp.service.AuditUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuditUserServiceImpl implements AuditUserService {
    private final AuditUserRepository repository;

    public AuditUserServiceImpl(AuditUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public AuditUser save(AuditUser entity) {
        return repository.save(entity);
    }

    @Override
    public List<AuditUser> save(List<AuditUser> entities) {
        return (List<AuditUser>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AuditUser> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AuditUser> findAll() {
        return (List<AuditUser>) repository.findAll();
    }

    @Override
    public Page<AuditUser> findAll(Pageable pageable) {
        Page<AuditUser> entityPage = repository.findAll(pageable);
        List<AuditUser> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AuditUser update(AuditUser entity, Long id) {
        Optional<AuditUser> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }

    @Override
    public AuditUser findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public AuditUser login(String username, String password) {
        return repository.findByUsernameAndPassword(username, Base64.getEncoder().encodeToString(password.getBytes()));
    }

    @Override
    public boolean deleteByDtoId(Long dtoId) {
        return repository.deleteByUserId(dtoId);
    }
}