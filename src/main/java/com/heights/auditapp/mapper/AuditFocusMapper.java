package com.heights.auditapp.mapper;

import com.heights.auditapp.dto.AuditFocusDTO;
import com.heights.auditapp.mapper.Impl.ReferenceMapper;
import com.heights.auditapp.model.AuditFocusEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AuditFocusMapper extends GenericMapper<AuditFocusEntity, AuditFocusDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    AuditFocusEntity asEntity(AuditFocusDTO dto);
}