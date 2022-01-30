package com.heights.auditapp.mapper;

import com.heights.auditapp.dto.AuditScopeDTO;
import com.heights.auditapp.model.AuditScope;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AuditScopeMapper extends GenericMapper<AuditScope, AuditScopeDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    AuditScope asEntity(AuditScopeDTO dto);
}