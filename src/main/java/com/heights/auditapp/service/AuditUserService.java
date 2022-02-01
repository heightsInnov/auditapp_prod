package com.heights.auditapp.service;

import com.heights.auditapp.model.AuditUser;

public interface AuditUserService extends GenericService<AuditUser, Long> {
    AuditUser findByUsername(String username);
}