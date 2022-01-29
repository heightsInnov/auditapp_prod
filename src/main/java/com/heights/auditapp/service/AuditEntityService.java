package com.heights.auditapp.service;

import com.heights.auditapp.model.AuditEntityEntity;

import java.util.List;

public interface AuditEntityService extends GenericService<AuditEntityEntity, Long> {
    List<AuditEntityEntity> findEntitiesByUniverseId(Long universeId);
}