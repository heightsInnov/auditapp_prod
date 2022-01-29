package com.heights.auditapp.dao;

import com.heights.auditapp.model.AuditFocusEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditFocusRepository extends PagingAndSortingRepository<AuditFocusEntity, Long> {
}