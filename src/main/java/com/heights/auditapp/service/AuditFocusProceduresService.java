package com.heights.auditapp.service;

import com.heights.auditapp.model.AuditFocusProcedures;
import com.heights.auditapp.model.ControllerRaise;

import java.util.List;

public interface AuditFocusProceduresService extends GenericService<AuditFocusProcedures, Long> {
    List<ControllerRaise> getExceptions();
}