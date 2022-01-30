package com.heights.auditapp.dao;

import com.heights.auditapp.model.AuditScopeApproaval;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditScopeApproavalRepository extends PagingAndSortingRepository<AuditScopeApproaval, Long> {
    List<AuditScopeApproaval> findByUserId(Long userId);
    List<AuditScopeApproaval> findByAuthorizerId(Long authorizerId);
}