package com.heights.auditapp.mapper;

import com.heights.auditapp.dto.AuditUserDTO;
import com.heights.auditapp.model.AuditUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AuditUserMapper extends GenericMapper<AuditUser, AuditUserDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    AuditUser asEntity(AuditUserDTO dto);
}