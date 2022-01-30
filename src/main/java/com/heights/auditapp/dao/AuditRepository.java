package com.heights.auditapp.dao;

import com.heights.auditapp.model.AuditEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditRepository extends PagingAndSortingRepository<AuditEntity, Long> {
    List<AuditEntity> findAllByUniverseId(Long universeId);
    Boolean existsByUniverseIdAndEntityName(Long universeId, String entityName);
}