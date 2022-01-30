package com.heights.auditapp.mapper;

import com.heights.auditapp.dto.AuditDTO;
import com.heights.auditapp.model.AuditEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AuditMapper extends GenericMapper<AuditEntity, AuditDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    AuditEntity asEntity(AuditDTO dto);
}