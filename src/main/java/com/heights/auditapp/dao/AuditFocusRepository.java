package com.heights.auditapp.dao;

import com.heights.auditapp.model.AuditFocus;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditFocusRepository extends PagingAndSortingRepository<AuditFocus, Long> {
}