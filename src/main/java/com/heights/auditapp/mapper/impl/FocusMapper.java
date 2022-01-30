package com.heights.auditapp.mapper.impl;

import com.heights.auditapp.dto.AuditFocusDTO;
import com.heights.auditapp.mapper.AuditFocusMapper;
import com.heights.auditapp.model.AuditFocus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FocusMapper implements AuditFocusMapper {
    @Override
    public AuditFocus asEntity(AuditFocusDTO dto) {
        AuditFocus entity = new AuditFocus();
        entity.setFocusId(dto.getId());
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
        return entity;
    }

    @Override
    public AuditFocusDTO asDTO(AuditFocus entity) {
        AuditFocusDTO dto = new AuditFocusDTO();
        dto.setId(entity.getFocusId());
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
        return dto;
    }

    @Override
    public List<AuditFocus> asEntityList(List<AuditFocusDTO> dtoList) {
        return dtoList.stream().map(this::asEntity).collect(Collectors.toList());
    }

    @Override
    public List<AuditFocusDTO> asDTOList(List<AuditFocus> entityList) {
        return entityList.stream().map(this::asDTO).collect(Collectors.toList());
    }
}
