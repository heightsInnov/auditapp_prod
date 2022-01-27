package com.heights.auditapp.mapper;

import com.heights.auditapp.dto.AuditUniverseDTO;
import com.heights.auditapp.mapper.Impl.ReferenceMapper;
import com.heights.auditapp.model.AuditUniverseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AuditUniverseMapper extends GenericMapper<AuditUniverseEntity, AuditUniverseDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    AuditUniverseEntity asEntity(AuditUniverseDTO dto);
}