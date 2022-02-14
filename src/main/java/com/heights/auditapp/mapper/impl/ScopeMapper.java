package com.heights.auditapp.mapper.impl;

import com.heights.auditapp.dto.AuditScopeDTO;
import com.heights.auditapp.mapper.AuditScopeMapper;
import com.heights.auditapp.model.AuditScope;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ScopeMapper implements AuditScopeMapper {
    SimpleDateFormat sdf;

    public ScopeMapper() {
        sdf = new SimpleDateFormat("yyyy-MM-dd");
    }

    @SneakyThrows
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
		try {
			if(dto.getSchedulledDate()!= null)
				entity.setSchedulledDate(sdf.parse(dto.getSchedulledDate()));
			if(dto.getAuditStartDate()!= null)
	            entity.setAuditStartDate(sdf.parse(dto.getAuditStartDate()));
	        if(dto.getAuditEndDate()!= null && !dto.getAuditEndDate().equals(""))
	            entity.setAuditEndDate(sdf.parse(dto.getAuditEndDate()));
		} catch (ParseException e) {
		    entity.setSchedulledDate(new Date());
		    entity.setAuditStartDate(new Date());
		    entity.setAuditEndDate(new Date());
		}
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
        if(entity.getSchedulledDate()!= null)
            dto.setSchedulledDate(sdf.format(entity.getSchedulledDate()));
        if(entity.getAuditStartDate()!= null)
            dto.setAuditStartDate(sdf.format(entity.getAuditStartDate()));
        if(entity.getAuditEndDate()!= null)
            dto.setAuditEndDate(sdf.format(entity.getAuditEndDate()));
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
