package com.heights.auditapp.mapper.impl;

import com.heights.auditapp.dto.AuditDTO;
import com.heights.auditapp.mapper.AuditMapper;
import com.heights.auditapp.model.AuditEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityMap implements AuditMapper {
    @Override
    public AuditEntity asEntity(AuditDTO dto) {
        AuditEntity entity = new AuditEntity();
        entity.setEntityName(dto.getEntityName());
        entity.setAuthStat(dto.getAuthStat());
        entity.setCreateDate(dto.getCreateDate());
        entity.setRecordStat(dto.getRecordStat());
        entity.setUniverseId(dto.getUniverseId());
        return entity;
    }

    @Override
    public AuditDTO asDTO(AuditEntity entity) {
        AuditDTO dto = new AuditDTO();
        dto.setEntityName(entity.getEntityName());
        dto.setAuthStat(entity.getAuthStat());
        dto.setId(entity.getEntityId());
        dto.setCreateDate(entity.getCreateDate());
        dto.setRecordStat(entity.getRecordStat());
        dto.setUniverseId(entity.getUniverseId());
        dto.setEntityId(entity.getEntityId());
        return dto;
    }

    @Override
    public List<AuditEntity> asEntityList(List<AuditDTO> dtoList) {
        return dtoList.stream().map(this::asEntity).collect(Collectors.toList());
    }

    @Override
    public List<AuditDTO> asDTOList(List<AuditEntity> entityList) {
        return entityList.stream().map(this::asDTO).collect(Collectors.toList());
    }
}
