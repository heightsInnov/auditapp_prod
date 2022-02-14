package com.heights.auditapp.mapper.impl;

import com.heights.auditapp.dto.AuditFocusProceduresDTO;
import com.heights.auditapp.mapper.AuditFocusProceduresMapper;
import com.heights.auditapp.model.AuditFocusProcedures;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FocusProcedureMapper implements AuditFocusProceduresMapper {
    @Override
    public AuditFocusProcedures asEntity(AuditFocusProceduresDTO dto) {
        return null;
    }

    @Override
    public AuditFocusProceduresDTO asDTO(AuditFocusProcedures entity) {
        return null;
    }

    @Override
    public List<AuditFocusProcedures> asEntityList(List<AuditFocusProceduresDTO> dtoList) {
        return null;
    }

    @Override
    public List<AuditFocusProceduresDTO> asDTOList(List<AuditFocusProcedures> entityList) {
        return null;
    }
}
