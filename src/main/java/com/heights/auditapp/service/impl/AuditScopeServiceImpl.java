package com.heights.auditapp.service.impl;

import com.heights.auditapp.dao.AuditFocusRepository;
import com.heights.auditapp.dao.AuditScopeRepository;
import com.heights.auditapp.dto.AuditScopeDTO;
import com.heights.auditapp.model.Approval_Status;
import com.heights.auditapp.model.AuditFocus;
import com.heights.auditapp.model.AuditScope;
import com.heights.auditapp.service.AuditScopeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class AuditScopeServiceImpl implements AuditScopeService {
    private final AuditScopeRepository repository;
    private final AuditFocusRepository focusRepository;

    public AuditScopeServiceImpl(AuditScopeRepository repository, AuditFocusRepository focusRepository) {
        this.repository = repository;
        this.focusRepository = focusRepository;
    }

    @Override
    public AuditScope save(AuditScope auditScope) {
        if(Boolean.TRUE.equals(repository.existsByEntityIdAndScopeOfAudit(auditScope.getEntityId(), auditScope.getScopeOfAudit())))
            update(auditScope, auditScope.getScopeId());
        return repository.save(auditScope);
    }

    @Override
    public List<AuditScope> save(List<AuditScope> entities) {
        return (List<AuditScope>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AuditScope> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AuditScope> findAll() {
        return (List<AuditScope>) repository.findAll();
    }

    @Override
    public Page<AuditScope> findAll(Pageable pageable) {
        Page<AuditScope> Page = repository.findAll(pageable);
        List<AuditScope> entities = Page.getContent();
        return new PageImpl<>(entities, pageable, Page.getTotalElements());
    }

    @Override
    public AuditScope update(AuditScope auditScope, Long scopeId) {
         return repository.save(auditScope);
    }

    @Override
    public boolean deleteByDtoId(Long dtoId) {
        return repository.deleteByScopeId(dtoId);
    }

    @Override
    public List<AuditScope> findByEntityId(Long entityId) {
        return repository.findAllByEntityId(entityId);
    }

    @Override
    public long countByUsernameAndApprovalStatus(String email, Long universeId) {
            return repository.findScopeByUniverseId(universeId)
                    .stream()
                    .filter(x -> {
                        if(email != null){
                            return x.getUserName().equals(email) && Approval_Status.AWAITING_APPROVAL.name().equals(x.getApprovalStatus());
                        }else{
                            return Approval_Status.AWAITING_APPROVAL.name().equals(x.getApprovalStatus());
                        }
                    }).count();
    }

    @Override
    public AuditScope updateScopeAuditor(long scopeId, String email) {
        return repository.updateScopeAuditor(email, scopeId);
    }

    @Override
    public List<AuditScope> findScopeByUniverseId(Long universeId) {
        return repository.findScopeByUniverseId(universeId);
    }

    public List<AuditScopeDTO> getScopeProgressLevel(List<AuditScopeDTO> auditScopeDTOS){
        for (AuditScopeDTO dto: auditScopeDTOS) {
            List<AuditFocus> focusList = focusRepository.findAllByScopeId(dto.getScopeId());
            int size = focusList.size();
            long counter = focusList.stream().filter(x -> x.getApprovalStatus().equals(Approval_Status.COMPLETED.name())).count();
            if(size > 0) {
                int cc = ((int)counter*100)/size;
                dto.setProgressLevel(counter > 0 ? cc : 0);
            }
        }
        return auditScopeDTOS;
    }
}