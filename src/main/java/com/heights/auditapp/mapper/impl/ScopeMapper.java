package com.heights.auditapp.mapper.impl;

import com.heights.auditapp.dto.AuditScopeDTO;
import com.heights.auditapp.mapper.AuditScopeMapper;
import com.heights.auditapp.model.AuditScope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScopeMapper implements AuditScopeMapper {
    @Override
    public AuditScope asEntity(AuditScopeDTO dto) {
        AuditScope entity = new AuditScope();
        entity.setScopeId(dto.getId());
        entity.setEntityId(dto.getEntityId());
        entity.setScopeOfAudit(dto.getScopeOfAudit());
        entity.setAuditPeriod(dto.getAuditPeriod());
        entity.setScopePurpose(dto.getScopePurpose());
        entity.setScopeDef(dto.getScopeDef());
        entity.setScopeObjectives(dto.getScopeObjectives());
        entity.setRiskRating(dto.getRiskRating());
        entity.setFrequency(dto.getFrequency());
        entity.setAuditType(dto.getAuditType());
        entity.setSchedulledDate(dto.getSchedulledDate());
        entity.setAuditStartDate(dto.getAuditStartDate());
        entity.setAuditEndDate(dto.getAuditEndDate());
        entity.setApprovalStatus(dto.getApprovalStatus());
        entity.setUserName(dto.getUserName());
        entity.setRecordStat(dto.getRecordStat());
        entity.setAuthStat(dto.getAuthStat());
        entity.setCreateDate(dto.getCreateDate());
        return entity;
    }

    @Override
    public AuditScopeDTO asDTO(AuditScope entity) {
        AuditScopeDTO dto = new AuditScopeDTO();
        dto.setId(entity.getScopeId());
        dto.setEntityId(entity.getEntityId());
        dto.setScopeOfAudit(entity.getScopeOfAudit());
        dto.setAuditPeriod(entity.getAuditPeriod());
        dto.setScopePurpose(entity.getScopePurpose());
        dto.setScopeDef(entity.getScopeDef());
        dto.setScopeObjectives(entity.getScopeObjectives());
        dto.setRiskRating(entity.getRiskRating());
        dto.setFrequency(entity.getFrequency());
        dto.setAuditType(entity.getAuditType());
        dto.setSchedulledDate(entity.getSchedulledDate());
        dto.setAuditStartDate(entity.getAuditStartDate());
        dto.setAuditEndDate(entity.getAuditEndDate());
        dto.setApprovalStatus(entity.getApprovalStatus());
        dto.setUserName(entity.getUserName());
        dto.setRecordStat(entity.getRecordStat());
        dto.setAuthStat(entity.getAuthStat());
        dto.setCreateDate(entity.getCreateDate());
        return dto;
    }

    @Override
    public List<AuditScope> asEntityList(List<AuditScopeDTO> dtoList) {
        return dtoList.stream().map(this::asEntity).collect(Collectors.toList());
    }

    @Override
    public List<AuditScopeDTO> asDTOList(List<AuditScope> entityList) {
        return entityList.stream().map(this::asDTO).collect(Collectors.toList());
    }
}
