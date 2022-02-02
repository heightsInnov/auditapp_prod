package com.heights.auditapp.dao;

import com.heights.auditapp.model.AuditScope;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditScopeRepository extends PagingAndSortingRepository<AuditScope, Long> {
    boolean existsByEntityIdAndScopeOfAudit(Long entityId, String scope);
    boolean deleteByScopeId(Long scopeId);
}