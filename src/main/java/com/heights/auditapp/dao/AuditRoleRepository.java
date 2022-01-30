package com.heights.auditapp.dao;

import com.heights.auditapp.model.AuditRole;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRoleRepository extends PagingAndSortingRepository<AuditRole, Long> {
}