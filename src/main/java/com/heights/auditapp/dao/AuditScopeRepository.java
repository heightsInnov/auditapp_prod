package com.heights.auditapp.dao;

import com.heights.auditapp.model.AuditScope;
import org.springframework.data.jpa.repository.Query;
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
    List<AuditScope> findAllByApprovalStatus(String approvalStatus);
    @Query(nativeQuery=true, value="update AUDIT_SCOPE set USER_NAME = :email where SCOPE_ID = :scopeId")
    AuditScope updateScopeAuditor(Long scopeId, String email);
    @Query(nativeQuery=true, value="select a.* from AUDIT_SCOPE a, AUDIT_ENTITY b, AUDIT_UNIVERSE c\n" +
            "where a.ENTITY_ID = b.ENTITY_ID and b.UNIVERSE_ID = c.UNIVERSE_ID and a.APPROVAL_STATUS in ('ACTIVE', 'COMPLETED')")
    List<AuditScope> findScopeByUniverseId(Long universeId);
}