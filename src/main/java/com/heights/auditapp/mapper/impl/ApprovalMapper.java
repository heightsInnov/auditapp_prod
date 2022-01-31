package com.heights.auditapp.mapper.impl;

import com.heights.auditapp.dto.AuditScopeApproavalDTO;
import com.heights.auditapp.mapper.AuditScopeApproavalMapper;
import com.heights.auditapp.model.AuditScopeApproaval;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApprovalMapper implements AuditScopeApproavalMapper {
    @Override
    public AuditScopeApproaval asEntity(AuditScopeApproavalDTO dto) {
        return null;
    }

    @Override
    public AuditScopeApproavalDTO asDTO(AuditScopeApproaval entity) {
        return null;
    }

    @Override
    public List<AuditScopeApproaval> asEntityList(List<AuditScopeApproavalDTO> dtoList) {
        return null;
    }

    @Override
    public List<AuditScopeApproavalDTO> asDTOList(List<AuditScopeApproaval> entityList) {
        return null;
    }
}
