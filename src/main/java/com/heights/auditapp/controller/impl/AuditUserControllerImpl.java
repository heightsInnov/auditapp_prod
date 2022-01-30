package com.heights.auditapp.controller.impl;

import com.heights.auditapp.controller.AuditUserController;
import com.heights.auditapp.dto.AuditUserDTO;
import com.heights.auditapp.mapper.AuditUserMapper;
import com.heights.auditapp.model.AuditUser;
import com.heights.auditapp.service.AuditUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/audit-user")
@RestController
public class AuditUserControllerImpl implements AuditUserController {
    private final AuditUserService auditUserService;
    private final AuditUserMapper auditUserMapper;

    public AuditUserControllerImpl(AuditUserService auditUserService, AuditUserMapper auditUserMapper) {
        this.auditUserService = auditUserService;
        this.auditUserMapper = auditUserMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuditUserDTO save(@RequestBody AuditUserDTO auditUserDTO) {
        AuditUser auditUser = auditUserMapper.asEntity(auditUserDTO);
        return auditUserMapper.asDTO(auditUserService.save(auditUser));
    }

    @Override
    @GetMapping("/{id}")
    public AuditUserDTO findById(@PathVariable("id") Long id) {
        AuditUser auditUser = auditUserService.findById(id).orElse(null);
        return auditUserMapper.asDTO(auditUser);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        auditUserService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<AuditUserDTO> list() {
        return auditUserMapper.asDTOList(auditUserService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<AuditUserDTO> pageQuery(Pageable pageable) {
        Page<AuditUser> auditUserPage = auditUserService.findAll(pageable);
        List<AuditUserDTO> dtoList = auditUserPage
                .stream()
                .map(auditUserMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, auditUserPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public AuditUserDTO update(@RequestBody AuditUserDTO auditUserDTO, @PathVariable("id") Long id) {
        AuditUser auditUser = auditUserMapper.asEntity(auditUserDTO);
        return auditUserMapper.asDTO(auditUserService.update(auditUser, id));
    }
}