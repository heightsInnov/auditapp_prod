package com.heights.auditapp.mapper.impl;

import com.heights.auditapp.dto.AuditUserDTO;
import com.heights.auditapp.encrypt.PBEncrytor;
import com.heights.auditapp.mapper.AuditUserMapper;
import com.heights.auditapp.model.AuditUser;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper implements AuditUserMapper {
    @Override
    public AuditUser asEntity(AuditUserDTO dto) {
        AuditUser user = new AuditUser();
        user.setUsername(dto.getUsername());
        user.setPassword(PBEncrytor.PBEncrypt(dto.getPassword()));
        user.setRole(dto.getRole());
        return user;
    }

    @Override
    public AuditUserDTO asDTO(AuditUser entity) {
        AuditUserDTO dto = new AuditUserDTO();
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setRole(entity.getRole());
        dto.setUsername(entity.getUsername());
        dto.setUserId(entity.getUserId());
        return dto;
    }

    @Override
    public List<AuditUser> asEntityList(List<AuditUserDTO> dtoList) {
        return dtoList.stream().map(this::asEntity).collect(Collectors.toList());
    }

    @Override
    public List<AuditUserDTO> asDTOList(List<AuditUser> entityList) {
        return entityList.stream().map(this::asDTO).collect(Collectors.toList());
    }
}
