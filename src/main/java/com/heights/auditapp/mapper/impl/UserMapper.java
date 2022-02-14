package com.heights.auditapp.mapper.impl;

import com.heights.auditapp.dto.AuditUserDTO;
import com.heights.auditapp.mapper.AuditUserMapper;
import com.heights.auditapp.model.AuditUser;
import com.heights.auditapp.service.AuditRoleService;
import com.heights.auditapp.service.impl.UtilHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class UserMapper implements AuditUserMapper {

    private final AuditRoleService auditRoleService;
    private final UtilHelper utilHelper;

    public UserMapper(AuditRoleService auditRoleService, UtilHelper utilHelper) {
        this.auditRoleService = auditRoleService;
        this.utilHelper = utilHelper;
    }

    @Override
    public AuditUser asEntity(AuditUserDTO dto) {
        AuditUser user = new AuditUser();
        user.setUsername(dto.getUsername());
        String pass = utilHelper.generatePassword();
        String enc = Base64.getEncoder().encodeToString(pass.getBytes());
        user.setPassword(enc);
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
        auditRoleService.findById(entity.getRole()).ifPresent(auditRole -> dto.setRoleName(auditRole.getName()));
        dto.setIsActive(entity.getIsActive() == '1'?"ACTIVE":"DISABLED");
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
