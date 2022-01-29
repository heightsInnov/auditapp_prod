package com.heights.auditapp.dao;

import com.heights.auditapp.model.AuditEntityEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditEntityRepository extends PagingAndSortingRepository<AuditEntityEntity, Long> {
//    List<AuditEntityEntity> findAllByUniverseUniverseId(Long universeId);
}