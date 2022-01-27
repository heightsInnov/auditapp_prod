package com.heights.auditapp.dao;

import com.heights.auditapp.model.AuditScopeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface AuditScopeRepository extends PagingAndSortingRepository<AuditScopeEntity, BigInteger> {
}