package com.heights.auditapp.mapper;

import com.heights.auditapp.dto.AuditEntityDTO;
import com.heights.auditapp.mapper.Impl.ReferenceMapper;
import com.heights.auditapp.model.AuditEntityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AuditEntityMapper extends GenericMapper<AuditEntityEntity, AuditEntityDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    AuditEntityEntity asEntity(AuditEntityDTO dto);
}