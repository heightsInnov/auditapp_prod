package com.heights.auditapp.dao;

import com.heights.auditapp.model.AuditUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditUserRepository extends PagingAndSortingRepository<AuditUser, Long> {
    AuditUser findByUsername(String username);
}