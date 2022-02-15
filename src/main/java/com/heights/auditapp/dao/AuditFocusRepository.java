package com.heights.auditapp.dao;

import com.heights.auditapp.model.AuditFocus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AuditFocusRepository extends PagingAndSortingRepository<AuditFocus, Long> {
    boolean deleteByFocusId(Long focusId);
    @Query(nativeQuery=true, value="update AUDIT_FOCUS set START_DATE = :startDate, START_FLAG = 'T' where FOCUS_ID = :focusId")
    boolean startExecution(Long focusId, LocalDate startDate);
    List<AuditFocus> findAllByScopeId(Long scopeId);
}