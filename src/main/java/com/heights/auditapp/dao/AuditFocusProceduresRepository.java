package com.heights.auditapp.dao;

import com.heights.auditapp.model.AuditFocusProcedures;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditFocusProceduresRepository extends PagingAndSortingRepository<AuditFocusProcedures, Long> {
}