package com.heights.auditapp.mapper;

import com.heights.auditapp.dto.AuditUniverseDTO;
import com.heights.auditapp.model.AuditUniverse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AuditUniverseMapper extends GenericMapper<AuditUniverse, AuditUniverseDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    AuditUniverse asEntity(AuditUniverseDTO dto);
}