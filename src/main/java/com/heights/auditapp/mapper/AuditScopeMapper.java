package com.heights.auditapp.mapper;

import com.heights.auditapp.dto.AuditScopeDTO;
import com.heights.auditapp.mapper.Impl.ReferenceMapper;
import com.heights.auditapp.model.AuditScopeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AuditScopeMapper extends GenericMapper<AuditScopeEntity, AuditScopeDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    AuditScopeEntity asEntity(AuditScopeDTO dto);
}