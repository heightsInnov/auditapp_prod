package com.heights.auditapp.service;


import com.heights.auditapp.model.AuditFocus;

import java.util.List;

public interface AuditFocusService extends GenericService<AuditFocus, Long> {
    boolean deleteByDtoId(Long dtoId);

    List<AuditFocus> findAuditFocusByScope(long scopeId);
}