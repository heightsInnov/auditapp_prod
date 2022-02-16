package com.heights.auditapp.dao;

import com.heights.auditapp.model.AuditFocusProcedures;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditFocusProceduresRepository extends PagingAndSortingRepository<AuditFocusProcedures, Long> {

    List<AuditFocusProcedures> findAllByFocusId(Long focusId);
}