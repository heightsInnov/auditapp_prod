package com.heights.auditapp.mapper;

import com.heights.auditapp.dto.AuditFocusDTO;
import com.heights.auditapp.model.AuditFocus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AuditFocusMapper extends GenericMapper<AuditFocus, AuditFocusDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    AuditFocus asEntity(AuditFocusDTO dto);
}