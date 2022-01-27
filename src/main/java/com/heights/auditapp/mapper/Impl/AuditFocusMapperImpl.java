package com.heights.auditapp.mapper.Impl;

import com.heights.auditapp.dto.AuditFocusDTO;
import com.heights.auditapp.model.AuditFocusEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuditFocusMapperImpl implements com.heights.auditapp.mapper.AuditFocusMapper {
    @Override
    public AuditFocusEntity asEntity(AuditFocusDTO dto) {
        return null;
    }

    @Override
    public AuditFocusDTO asDTO(AuditFocusEntity entity) {
        return null;
    }

    @Override
    public List<AuditFocusEntity> asEntityList(List<AuditFocusDTO> dtoList) {
        return null;
    }

    @Override
    public List<AuditFocusDTO> asDTOList(List<AuditFocusEntity> entityList) {
        return null;
    }
}
