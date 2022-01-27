package com.heights.auditapp.mapper.Impl;

import com.heights.auditapp.dto.AuditScopeDTO;
import com.heights.auditapp.mapper.AuditScopeMapper;
import com.heights.auditapp.model.AuditScopeEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuditScopeMapperImpl implements AuditScopeMapper {
    @Override
    public AuditScopeEntity asEntity(AuditScopeDTO dto) {
        return null;
    }

    @Override
    public AuditScopeDTO asDTO(AuditScopeEntity entity) {
        return null;
    }

    @Override
    public List<AuditScopeEntity> asEntityList(List<AuditScopeDTO> dtoList) {
        return null;
    }

    @Override
    public List<AuditScopeDTO> asDTOList(List<AuditScopeEntity> entityList) {
        return null;
    }
}
