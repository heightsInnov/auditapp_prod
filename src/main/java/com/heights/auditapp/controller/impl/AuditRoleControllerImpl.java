package com.heights.auditapp.controller.impl;

import com.heights.auditapp.controller.AuditRoleController;
import com.heights.auditapp.dto.AuditRoleDTO;
import com.heights.auditapp.mapper.AuditRoleMapper;
import com.heights.auditapp.model.AuditRole;
import com.heights.auditapp.service.AuditRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/audit-role")
@RestController
public class AuditRoleControllerImpl implements AuditRoleController {
    private final AuditRoleService auditRoleService;
    private final AuditRoleMapper auditRoleMapper;

    public AuditRoleControllerImpl(AuditRoleService auditRoleService, AuditRoleMapper auditRoleMapper) {
        this.auditRoleService = auditRoleService;
        this.auditRoleMapper = auditRoleMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuditRoleDTO save(@RequestBody AuditRoleDTO auditRoleDTO) {
        AuditRole auditRole = auditRoleMapper.asEntity(auditRoleDTO);
        return auditRoleMapper.asDTO(auditRoleService.save(auditRole));
    }

    @Override
    @GetMapping("/{id}")
    public AuditRoleDTO findById(@PathVariable("id") Long id) {
        AuditRole auditRole = auditRoleService.findById(id).orElse(null);
        return auditRoleMapper.asDTO(auditRole);
    }

    @Override
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return auditRoleService.deleteByDtoId(id);
    }

    @Override
    @GetMapping
    public List<AuditRoleDTO> list() {
        return auditRoleMapper.asDTOList(auditRoleService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<AuditRoleDTO> pageQuery(Pageable pageable) {
        Page<AuditRole> auditRolePage = auditRoleService.findAll(pageable);
        List<AuditRoleDTO> dtoList = auditRolePage
                .stream()
                .map(auditRoleMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, auditRolePage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public AuditRoleDTO update(@RequestBody AuditRoleDTO auditRoleDTO, @PathVariable("id") Long id) {
        AuditRole auditRole = auditRoleMapper.asEntity(auditRoleDTO);
        return auditRoleMapper.asDTO(auditRoleService.update(auditRole, id));
    }
}