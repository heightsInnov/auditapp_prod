package com.heights.auditapp.mapper;

import com.heights.auditapp.dto.AuditScopeApproavalDTO;
import com.heights.auditapp.model.AuditScopeApproaval;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AuditScopeApproavalMapper extends GenericMapper<AuditScopeApproaval, AuditScopeApproavalDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    AuditScopeApproaval asEntity(AuditScopeApproavalDTO dto);
}