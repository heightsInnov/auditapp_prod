package com.heights.auditapp.mapper;

import com.heights.auditapp.dto.AuditFocusProceduresDTO;
import com.heights.auditapp.model.AuditFocusProcedures;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AuditFocusProceduresMapper extends GenericMapper<AuditFocusProcedures, AuditFocusProceduresDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    AuditFocusProcedures asEntity(AuditFocusProceduresDTO dto);
}