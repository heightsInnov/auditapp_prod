package com.heights.auditapp.dao;

import com.heights.auditapp.model.AuditEntityEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface AuditEntityRepository extends PagingAndSortingRepository<AuditEntityEntity, BigInteger> {
}