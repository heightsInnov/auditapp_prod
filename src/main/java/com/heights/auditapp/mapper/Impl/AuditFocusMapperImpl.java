package com.heights.auditapp.mapper.Impl;

import com.heights.auditapp.dto.AuditFocusDTO;
import com.heights.auditapp.model.AuditFocusEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuditFocusMapperImpl implements com.heights.auditapp.mapper.AuditFocusMapper {
    @Override
    public AuditFocusEntity asEntity(AuditFocusDTO dto) {
        AuditFocusEntity entity = new AuditFocusEntity();
        entity.setId(dto.getId());
        entity.setScopeId(dto.getScopeId());
        entity.setAreaOfFocus(dto.getAreaOfFocus());
        entity.setViewFlag(dto.getViewFlag());
        entity.setScheduledFlag(dto.getScheduledFlag());
        entity.setSchedulledDate(dto.getSchedulledDate());
        entity.setStartDate(dto.getStartDate());
        entity.setWorkProgramStart(dto.getWorkProgramStart());
        entity.setStartFlag(dto.getStartFlag());
        entity.setRiskRating(dto.getRiskRating());
        entity.setFocusException(dto.getFocusException());
        entity.setFocusRecommendation(dto.getFocusRecommendation());
        entity.setComments(dto.getComments());
        entity.setControlStatus(dto.getControlStatus());
        entity.setRequestAdditionalInfo(dto.getRequestAdditionalInfo());
        entity.setRecipientName(dto.getRecipientName());
        entity.setRecipientEmail(dto.getRecipientEmail());
        entity.setDueDate(dto.getDueDate());
        entity.setExceptionFlag(dto.getExceptionFlag());
        entity.setApprovalStatus(dto.getApprovalStatus());
        entity.setUserName(dto.getUserName());
        entity.setRecordStat(dto.getRecordStat());
        entity.setAuthStat(dto.getAuthStat());
        entity.setCreateDate(dto.getCreateDate());
        entity.setAuditScopeByScopeId(dto.getAuditScopeByScopeId());
        return entity;
    }

    @Override
    public AuditFocusDTO asDTO(AuditFocusEntity entity) {
        AuditFocusDTO dto = new AuditFocusDTO();
        dto.setId(entity.getId());
        dto.setScopeId(entity.getScopeId());
        dto.setAreaOfFocus(entity.getAreaOfFocus());
        dto.setViewFlag(entity.getViewFlag());
        dto.setScheduledFlag(entity.getScheduledFlag());
        dto.setSchedulledDate(entity.getSchedulledDate());
        dto.setStartDate(entity.getStartDate());
        dto.setWorkProgramStart(entity.getWorkProgramStart());
        dto.setStartFlag(entity.getStartFlag());
        dto.setRiskRating(entity.getRiskRating());
        dto.setFocusException(entity.getFocusException());
        dto.setFocusRecommendation(entity.getFocusRecommendation());
        dto.setComments(entity.getComments());
        dto.setControlStatus(entity.getControlStatus());
        dto.setRequestAdditionalInfo(entity.getRequestAdditionalInfo());
        dto.setRecipientName(entity.getRecipientName());
        dto.setRecipientEmail(entity.getRecipientEmail());
        dto.setDueDate(entity.getDueDate());
        dto.setExceptionFlag(entity.getExceptionFlag());
        dto.setApprovalStatus(entity.getApprovalStatus());
        dto.setUserName(entity.getUserName());
        dto.setRecordStat(entity.getRecordStat());
        dto.setAuthStat(entity.getAuthStat());
        dto.setCreateDate(entity.getCreateDate());
        dto.setAuditScopeByScopeId(entity.getAuditScopeByScopeId());
        return dto;
    }

    @Override
    public List<AuditFocusEntity> asEntityList(List<AuditFocusDTO> dtoList) {
        return dtoList.stream().map(this::asEntity).collect(Collectors.toList());
    }

    @Override
    public List<AuditFocusDTO> asDTOList(List<AuditFocusEntity> entityList) {
        return entityList.stream().map(this::asDTO).collect(Collectors.toList());
    }
}
