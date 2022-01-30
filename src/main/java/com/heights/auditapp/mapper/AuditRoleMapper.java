package com.heights.auditapp.mapper;

import com.heights.auditapp.dto.AuditRoleDTO;
import com.heights.auditapp.model.AuditRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AuditRoleMapper extends GenericMapper<AuditRole, AuditRoleDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    AuditRole asEntity(AuditRoleDTO dto);
}