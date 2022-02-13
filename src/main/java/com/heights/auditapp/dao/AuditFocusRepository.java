package com.heights.auditapp.dao;

import com.heights.auditapp.model.AuditFocus;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditFocusRepository extends PagingAndSortingRepository<AuditFocus, Long> {
    boolean deleteByFocusId(Long focusId);

    List<AuditFocus> findAllByScopeId(Long scopeId);
}