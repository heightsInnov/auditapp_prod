package com.heights.auditapp.mapper.Impl;

import com.heights.auditapp.dto.AuditUniverseDTO;
import com.heights.auditapp.mapper.AuditUniverseMapper;
import com.heights.auditapp.model.AuditUniverseEntity;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuditUniverseMapperImpl implements AuditUniverseMapper {
    @Override
    public AuditUniverseEntity asEntity(AuditUniverseDTO dto) {
        AuditUniverseEntity entity = new AuditUniverseEntity();
        entity.setId(dto.getId());
        entity.setUniverseName(dto.getUniverseName());
        entity.setRecordStat(dto.getRecordStat());
        entity.setAuthStat(dto.getAuthStat());
        entity.setCreateDate(new Date(new java.util.Date().getTime()));
        return entity;
    }

    @Override
    public AuditUniverseDTO asDTO(AuditUniverseEntity entity) {
        AuditUniverseDTO dto = new AuditUniverseDTO();
        dto.setId(entity.getId());
        dto.setUniverseName(entity.getUniverseName());
        dto.setRecordStat(entity.getRecordStat());
        dto.setAuthStat(entity.getAuthStat());
        dto.setCreateDate(entity.getCreateDate());
        return dto;
    }

    @Override
    public List<AuditUniverseEntity> asEntityList(List<AuditUniverseDTO> dtoList) {
        return dtoList.stream().map(this::asEntity).collect(Collectors.toList());
    }

    @Override
    public List<AuditUniverseDTO> asDTOList(List<AuditUniverseEntity> entityList) {
        return entityList.stream().map(this::asDTO).collect(Collectors.toList());
    }
}
