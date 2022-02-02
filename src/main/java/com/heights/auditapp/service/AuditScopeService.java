package com.heights.auditapp.service;


import com.heights.auditapp.model.AuditScope;

import java.util.List;

public interface AuditScopeService extends GenericService<AuditScope, Long> {
    boolean deleteByDtoId(Long dtoId);
    List<AuditScope> findByEntityId(Long entityId);
}