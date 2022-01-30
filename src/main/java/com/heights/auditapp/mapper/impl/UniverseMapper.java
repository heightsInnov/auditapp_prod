package com.heights.auditapp.mapper.impl;

import com.heights.auditapp.dto.AuditUniverseDTO;
import com.heights.auditapp.mapper.AuditUniverseMapper;
import com.heights.auditapp.model.AuditUniverse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UniverseMapper implements AuditUniverseMapper {
    @Override
    public AuditUniverse asEntity(AuditUniverseDTO dto) {
        AuditUniverse entity = new AuditUniverse();
        entity.setUniverseId(dto.getId());
        entity.setUniverseName(dto.getUniverseName());
        entity.setRecordStat(dto.getRecordStat());
        entity.setAuthStat(dto.getAuthStat());
        entity.setCreateDate(dto.getCreateDate());
        return entity;
    }

    @Override
    public AuditUniverseDTO asDTO(AuditUniverse entity) {
        AuditUniverseDTO dto = new AuditUniverseDTO();
        dto.setUniverseId(entity.getUniverseId());
        dto.setUniverseName(entity.getUniverseName());
        dto.setRecordStat(entity.getRecordStat());
        dto.setAuthStat(entity.getAuthStat());
        dto.setCreateDate(entity.getCreateDate());
        return dto;
    }

    @Override
    public List<AuditUniverse> asEntityList(List<AuditUniverseDTO> dtoList) {
        return dtoList.stream().map(this::asEntity).collect(Collectors.toList());
    }

    @Override
    public List<AuditUniverseDTO> asDTOList(List<AuditUniverse> entityList) {
        return entityList.stream().map(this::asDTO).collect(Collectors.toList());
    }
}
