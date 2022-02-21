package com.heights.auditapp.service;


import com.heights.auditapp.dto.AuditScopeDTO;
import com.heights.auditapp.model.AuditScope;

import java.util.List;

public interface AuditScopeService extends GenericService<AuditScope, Long> {
    boolean deleteByDtoId(Long dtoId);
    List<AuditScope> findByEntityId(Long entityId);
    long countByUsernameAndApprovalStatus(String email, Long universeId);
    AuditScope updateScopeAuditor(long scopeId, String email);
    List<AuditScope> findScopeByUniverseId(Long universeId);
    List<AuditScopeDTO> getScopeProgressLevel(List<AuditScopeDTO> auditScopeDTOS);
}