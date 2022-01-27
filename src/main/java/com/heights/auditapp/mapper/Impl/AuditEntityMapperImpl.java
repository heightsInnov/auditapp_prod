package com.heights.auditapp.mapper.Impl;

import com.heights.auditapp.dto.AuditEntityDTO;
import com.heights.auditapp.model.AuditEntityEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuditEntityMapperImpl implements com.heights.auditapp.mapper.AuditEntityMapper {
    @Override
    public AuditEntityEntity asEntity(AuditEntityDTO dto) {
        return null;
    }

    @Override
    public AuditEntityDTO asDTO(AuditEntityEntity entity) {
        return null;
    }

    @Override
    public List<AuditEntityEntity> asEntityList(List<AuditEntityDTO> dtoList) {
        return null;
    }

    @Override
    public List<AuditEntityDTO> asDTOList(List<AuditEntityEntity> entityList) {
        return null;
    }
}
