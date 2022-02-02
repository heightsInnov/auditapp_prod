package com.heights.auditapp.service;

import com.heights.auditapp.model.AuditEntity;

public interface AuditService extends GenericService<AuditEntity, Long> {
    boolean deleteByDtoId(Long dtoId);
}