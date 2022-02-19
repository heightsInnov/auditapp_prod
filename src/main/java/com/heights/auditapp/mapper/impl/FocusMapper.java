package com.heights.auditapp.mapper.impl;

import com.heights.auditapp.dto.AuditFocusDTO;
import com.heights.auditapp.mapper.AuditFocusMapper;
import com.heights.auditapp.model.Approval_Status;
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
        entity.setScheduledFlag(dto.getScheduledFlag());
        entity.setSchedulledDate(dto.getSchedulledDate());
        entity.setStartDate(dto.getStartDate());
        entity.setStartFlag(dto.getStartFlag());
        entity.setControlStatus(dto.getControlStatus());
        entity.setApprovalStatus(dto.getApprovalStatus().name());
        entity.setRecordStat(dto.getRecordStat());
        entity.setAuthStat(dto.getAuthStat());
        entity.setCreateDate(dto.getCreateDate());
        entity.setUserId(dto.getUserId());
        return entity;
    }

    @Override
    public AuditFocusDTO asDTO(AuditFocus entity) {
        AuditFocusDTO dto = new AuditFocusDTO();
        dto.setId(entity.getFocusId());
        dto.setScopeId(entity.getScopeId());
        dto.setAreaOfFocus(entity.getAreaOfFocus());
        dto.setScheduledFlag(entity.getScheduledFlag());
        dto.setSchedulledDate(entity.getSchedulledDate());
        dto.setStartDate(entity.getStartDate());
        dto.setStartFlag(entity.getStartFlag());
        dto.setControlStatus(entity.getControlStatus());
        dto.setApprovalStatus(Approval_Status.valueOf(entity.getApprovalStatus()));
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
