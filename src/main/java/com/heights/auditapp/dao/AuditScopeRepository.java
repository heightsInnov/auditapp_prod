package com.heights.auditapp.dao;

import com.heights.auditapp.model.AuditScope;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditScopeRepository extends PagingAndSortingRepository<AuditScope, Long> {
    boolean existsByEntityIdAndScopeOfAudit(Long entityId, String scope);
    boolean deleteByScopeId(Long scopeId);
    List<AuditScope> findAllByEntityId(Long entityId);
    long countAllByUserNameAndApprovalStatus(String username, String approvalStatus);
    long countAllByApprovalStatus(String approvalStatus);
}