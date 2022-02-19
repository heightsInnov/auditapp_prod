package com.heights.auditapp.mapper.impl;

import com.heights.auditapp.dto.AuditScopeDTO;
import com.heights.auditapp.mapper.AuditScopeMapper;
import com.heights.auditapp.model.AUDIT_TYPE;
import com.heights.auditapp.model.Approval_Status;
import com.heights.auditapp.model.AuditScope;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ScopeMapper implements AuditScopeMapper {
    SimpleDateFormat sdf;

    public ScopeMapper() {
        sdf = new SimpleDateFormat("yyyy-MM-dd");
    }

    public static void main(String[] args) {
        LocalDate d = LocalDate.now().plusDays(5);
        LocalDate d2 = LocalDate.now().plusDays(18);
        System.out.println(d.toString());
        System.out.println(d2.toString());

        System.out.println(ChronoUnit.WEEKS.between(d, d2));
        System.out.println(ChronoUnit.DAYS.between(d, d2));
    }

    @SneakyThrows
    @Override
    public AuditScope asEntity(AuditScopeDTO dto) {
        AuditScope entity = new AuditScope();
        entity.setScopeId(dto.getId());
        entity.setEntityId(dto.getEntityId());
        entity.setScopeOfAudit(dto.getScopeOfAudit());
        entity.setScopePurpose(dto.getScopePurpose());
        entity.setScopeDef(dto.getScopeDef());
        entity.setScopeObjectives(dto.getScopeObjectives());
        entity.setRiskRating(dto.getRiskRating());
        entity.setFrequency(dto.getFrequency());
        entity.setAuditType(dto.getAuditType());

        if (dto.getSchedulledDate() != null)
            entity.setSchedulledDate(dto.getSchedulledDate());
        if (dto.getAuditStartDate() != null)
            entity.setAuditStartDate(dto.getAuditStartDate());
        if (dto.getAuditEndDate() != null)
            entity.setAuditEndDate(dto.getAuditEndDate());

        entity.setApprovalStatus(dto.getApprovalStatus().name());
        entity.setUserName(dto.getUserName());
        entity.setRecordStat(dto.getRecordStat());
        entity.setAuthStat(dto.getAuthStat());
        entity.setCreateDate(dto.getCreateDate());
        entity.setAssignedTo(dto.getAssignedTo());
        entity.setAuditPeriod(String.valueOf(ChronoUnit.WEEKS.between(dto.getAuditStartDate(), dto.getAuditEndDate())));
        return entity;
    }

    @Override
    public List<AuditScope> asEntityList(List<AuditScopeDTO> dtoList) {
        return dtoList.stream().map(this::asEntity).collect(Collectors.toList());
    }

    @Override
    public List<AuditScopeDTO> asDTOList(List<AuditScope> entityList) {
        return entityList.stream().map(this::asDTO).collect(Collectors.toList());
    }

    @Override
    public AuditScopeDTO asDTO(AuditScope entity) {
        AuditScopeDTO dto = new AuditScopeDTO();
        dto.setScopeId(entity.getScopeId());
        dto.setEntityId(entity.getEntityId());
        dto.setScopeOfAudit(entity.getScopeOfAudit());
        dto.setAuditPeriod(entity.getAuditPeriod());
        dto.setScopePurpose(entity.getScopePurpose());
        dto.setScopeDef(entity.getScopeDef());
        dto.setScopeObjectives(entity.getScopeObjectives());
        dto.setRiskRating(entity.getRiskRating());
        dto.setFrequency(entity.getFrequency());
        dto.setAuditType(AUDIT_TYPE.getEnumByString(Integer.parseInt(entity.getAuditType())).replace("_", " "));
        if (entity.getSchedulledDate() != null)
            dto.setSchedulledDate(entity.getSchedulledDate());
        if (entity.getAuditStartDate() != null)
            dto.setAuditStartDate(entity.getAuditStartDate());
        if (entity.getAuditEndDate() != null)
            dto.setAuditEndDate(entity.getAuditEndDate());
        dto.setApprovalStatus(Approval_Status.valueOf(entity.getApprovalStatus()));
        dto.setUserName(entity.getUserName());
        dto.setRecordStat(entity.getRecordStat());
        dto.setAuthStat(entity.getAuthStat());
        dto.setCreateDate(entity.getCreateDate());
        dto.setAssignedTo(entity.getAssignedTo());
        return dto;
    }
}
