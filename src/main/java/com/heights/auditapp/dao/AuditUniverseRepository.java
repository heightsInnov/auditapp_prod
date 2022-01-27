package com.heights.auditapp.dao;

import com.heights.auditapp.model.AuditUniverseEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface AuditUniverseRepository extends PagingAndSortingRepository<AuditUniverseEntity, BigInteger> {
}