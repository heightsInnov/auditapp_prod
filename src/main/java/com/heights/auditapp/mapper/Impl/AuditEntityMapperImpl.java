package com.heights.auditapp.mapper.Impl;

import com.heights.auditapp.dto.AuditEntityDTO;
import com.heights.auditapp.model.AuditEntityEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuditEntityMapperImpl implements com.heights.auditapp.mapper.AuditEntityMapper {
    @Override
    public AuditEntityEntity asEntity(AuditEntityDTO dto) {
        AuditEntityEntity entity = new AuditEntityEntity();
        entity.setEntityName(dto.getEntityName());
        entity.setAuditScopesById(dto.getAuditScopesById());
        entity.setAuthStat(dto.getAuthStat());
        entity.setId(dto.getId());
        entity.setCreateDate(dto.getCreateDate());
        entity.setAuditUniverseByUniverseId(dto.getAuditUniverseByUniverseId());
        entity.setRecordStat(dto.getRecordStat());
        entity.setUniverseId(dto.getUniverseId());
        return entity;
    }

    @Override
    public AuditEntityDTO asDTO(AuditEntityEntity entity) {
        AuditEntityDTO dto = new AuditEntityDTO();
        dto.setEntityName(entity.getEntityName());
        dto.setAuditScopesById(entity.getAuditScopesById());
        dto.setAuthStat(entity.getAuthStat());
        dto.setId(entity.getId());
        dto.setCreateDate(entity.getCreateDate());
        dto.setAuditUniverseByUniverseId(entity.getAuditUniverseByUniverseId());
        dto.setRecordStat(entity.getRecordStat());
        dto.setUniverseId(entity.getUniverseId());
        return dto;
    }

    @Override
    public List<AuditEntityEntity> asEntityList(List<AuditEntityDTO> dtoList) {
        return dtoList.stream().map(this::asEntity).collect(Collectors.toList());
    }

    @Override
    public List<AuditEntityDTO> asDTOList(List<AuditEntityEntity> entityList) {
        return entityList.stream().map(this::asDTO).collect(Collectors.toList());
    }
}
