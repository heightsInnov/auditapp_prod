package com.heights.auditapp.mapper.Impl;

import com.heights.auditapp.dto.AuditUniverseDTO;
import com.heights.auditapp.mapper.AuditUniverseMapper;
import com.heights.auditapp.model.AuditUniverseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuditUniverseMapperImpl implements AuditUniverseMapper {
    @Override
    public AuditUniverseEntity asEntity(AuditUniverseDTO dto) {
        return null;
    }

    @Override
    public AuditUniverseDTO asDTO(AuditUniverseEntity entity) {
        return null;
    }

    @Override
    public List<AuditUniverseEntity> asEntityList(List<AuditUniverseDTO> dtoList) {
        return null;
    }

    @Override
    public List<AuditUniverseDTO> asDTOList(List<AuditUniverseEntity> entityList) {
        return null;
    }
}
