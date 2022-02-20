package com.heights.auditapp.service.impl;

import com.heights.auditapp.dao.AuditFocusRepository;
import com.heights.auditapp.dao.AuditScopeRepository;
import com.heights.auditapp.dto.AuditScopeDTO;
import com.heights.auditapp.model.Approval_Status;
import com.heights.auditapp.model.AuditFocus;
import com.heights.auditapp.model.AuditScope;
import com.heights.auditapp.service.AuditScopeService;
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
    public AuditScope update(AuditScope auditScope, Long id) {
        Optional<AuditScope> optional = findById(id);
        if (optional.isPresent()) {
            AuditScope scope = optional.get();
            if (auditScope.getScopeDef() != null)
                scope.setScopeDef(auditScope.getScopeDef());
            if (auditScope.getAuditEndDate() != null)
                scope.setAuditEndDate(auditScope.getAuditEndDate());
            if (auditScope.getAuditPeriod() != null)
                scope.setScopeDef(auditScope.getScopeDef());
            if (auditScope.getAuditStartDate() != null)
                scope.setAuditStartDate(auditScope.getAuditStartDate());
            if (auditScope.getAuditType() != null)
                scope.setAuditType(auditScope.getAuditType());
            if (auditScope.getFrequency() != null)
                scope.setFrequency(auditScope.getFrequency());
            if (auditScope.getRiskRating() != null)
                scope.setRiskRating(auditScope.getRiskRating());
            if (auditScope.getSchedulledDate() != null)
                scope.setSchedulledDate(auditScope.getSchedulledDate());
            if (auditScope.getScopeObjectives() != null)
                scope.setScopeObjectives(auditScope.getScopeObjectives());
            if (auditScope.getScopePurpose() != null)
                scope.setScopePurpose(auditScope.getScopePurpose());
            return save(scope);
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "No data found corresponding to scope Id");
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
    public long countByUsernameAndApprovalStatus(String email) {
        return email == null ? repository.countAllByApprovalStatus(Approval_Status.AWAITING_APPROVAL.name()) : repository.countAllByUserNameAndApprovalStatus(email, Approval_Status.AWAITING_APPROVAL.name());
    }

    @Override
    public AuditScope updateScopeAuditor(long scopeId, String email) {
        return repository.updateScopeAuditor(scopeId, email);
    }

    @Override
    public List<AuditScope> findScopeByUniverseId(Long universeId) {
        return repository.findScopeByUniverseId(universeId);
    }

    public List<AuditScopeDTO> getScopeProgressLevel(List<AuditScopeDTO> auditScopeDTOS){
        for (AuditScopeDTO dto: auditScopeDTOS) {
            List<AuditFocus> focusList = focusRepository.findAllByScopeId(dto.getScopeId());
            long counter = focusList.stream().filter(x -> x.getApprovalStatus().equals(Approval_Status.COMPLETED.name())).count();
            int size = focusList.size();
            if(size > 0) {
                long cc = (counter*100)/size;
                dto.setProgressLevel(counter > 0 ? (int) cc : 0);
            }
        }
        return auditScopeDTOS;
    }
}