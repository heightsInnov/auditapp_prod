package com.heights.auditapp.mapper.impl;

import com.heights.auditapp.dto.AuditFocusProceduresDTO;
import com.heights.auditapp.mapper.AuditFocusProceduresMapper;
import com.heights.auditapp.model.AuditFocusProcedures;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FocusProcedureMapper implements AuditFocusProceduresMapper {
    @Override
    public AuditFocusProcedures asEntity(AuditFocusProceduresDTO dto) {
        AuditFocusProcedures entity = new AuditFocusProcedures();
        entity.setFocusId(dto.getFocusId());
        entity.setAdditionalInfo(dto.getAdditionalInfo());
        entity.setScheduledFlag(dto.getScheduledFlag());
        entity.setSchedulledDate(dto.getSchedulledDate());
        entity.setStartDate(dto.getStartDate());
        entity.setStartFlag(dto.getStartFlag());
        entity.setControlStatus(dto.getControlStatus());
        entity.setRecordStat(dto.getRecordStat());
        entity.setAuthStat(dto.getAuthStat());
        entity.setUserId(dto.getUserId());
        entity.setComments(dto.getComments());
        entity.setDueDate(dto.getDueDate());
        entity.setException(dto.getException());
        entity.setExceptionFlag(dto.getExceptionFlag());
        entity.setProcedure(dto.getProcedure());
        entity.setProgressLevel(dto.getProgressLevel());
        entity.setRecipientEmail(dto.getRecipientEmail());
        entity.setRecipientName(dto.getRecipientName());
        entity.setRecommendation(dto.getRecommendation());
        entity.setRiskRating(dto.getRiskRating());
        entity.setWorkProgramStart(dto.getWorkProgramStart());
        entity.setProgressLevel(dto.getProgressLevel());
        return entity;
    }

    @Override
    public AuditFocusProceduresDTO asDTO(AuditFocusProcedures dto) {
        AuditFocusProceduresDTO entity = new AuditFocusProceduresDTO();
        entity.setFocusId(dto.getFocusId());
        entity.setAdditionalInfo(dto.getAdditionalInfo());
        entity.setScheduledFlag(dto.getScheduledFlag());
        entity.setSchedulledDate(dto.getSchedulledDate());
        entity.setStartDate(dto.getStartDate());
        entity.setStartFlag(dto.getStartFlag());
        entity.setControlStatus(dto.getControlStatus());
        entity.setRecordStat(dto.getRecordStat());
        entity.setAuthStat(dto.getAuthStat());
        entity.setUserId(dto.getUserId());
        entity.setComments(dto.getComments());
        entity.setDueDate(dto.getDueDate());
        entity.setException(dto.getException());
        entity.setExceptionFlag(dto.getExceptionFlag());
        entity.setProcedure(dto.getProcedure());
        entity.setProgressLevel(dto.getProgressLevel());
        entity.setRecipientEmail(dto.getRecipientEmail());
        entity.setRecipientName(dto.getRecipientName());
        entity.setRecommendation(dto.getRecommendation());
        entity.setRiskRating(dto.getRiskRating());
        entity.setWorkProgramStart(dto.getWorkProgramStart());
        entity.setProgressLevel(dto.getProgressLevel());
        return entity;
    }

    @Override
    public List<AuditFocusProcedures> asEntityList(List<AuditFocusProceduresDTO> dtoList) {
        return dtoList.stream().map(this::asEntity).collect(Collectors.toList());
    }

    @Override
    public List<AuditFocusProceduresDTO> asDTOList(List<AuditFocusProcedures> entityList) {
        return entityList.stream().map(this::asDTO).collect(Collectors.toList());
    }
}
