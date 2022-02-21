package com.heights.auditapp.dao;

import com.heights.auditapp.model.AuditUniverse;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditUniverseRepository extends PagingAndSortingRepository<AuditUniverse, Long> {
    int deleteByUniverseId(long universeId);
}