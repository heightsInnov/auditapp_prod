package com.heights.auditapp.dao;

import com.heights.auditapp.model.AuditFocusEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface AuditFocusRepository extends PagingAndSortingRepository<AuditFocusEntity, BigInteger> {
}