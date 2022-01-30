package com.heights.auditapp.mapper.impl;

import com.heights.auditapp.dto.AuditRoleDTO;
import com.heights.auditapp.mapper.AuditRoleMapper;
import com.heights.auditapp.model.AuditRole;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleMapper implements AuditRoleMapper {
    @Override
    public AuditRole asEntity(AuditRoleDTO dto) {
        AuditRole role = new AuditRole();
        role.setName(dto.getName());
        return role;
    }

    @Override
    public AuditRoleDTO asDTO(AuditRole entity) {
        AuditRoleDTO dto = new AuditRoleDTO();
        dto.setRoleId(entity.getRoleId());
        dto.setName(entity.getName());
        dto.setDateCreated(entity.getDateCreated());
        return dto;
    }

    @Override
    public List<AuditRole> asEntityList(List<AuditRoleDTO> dtoList) {
        return dtoList.stream().map(this::asEntity).collect(Collectors.toList());
    }

    @Override
    public List<AuditRoleDTO> asDTOList(List<AuditRole> entityList) {
        return entityList.stream().map(this::asDTO).collect(Collectors.toList());
    }
}
