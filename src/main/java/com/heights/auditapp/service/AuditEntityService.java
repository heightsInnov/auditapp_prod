package com.heights.auditapp.service;

import com.heights.auditapp.model.AuditEntity;

import java.util.List;

public interface AuditEntityService extends GenericService<AuditEntity, Long> {
    List<AuditEntity> findEntitiesByUniverseId(Long universeId);
}