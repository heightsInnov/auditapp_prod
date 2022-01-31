package com.heights.auditapp.controller.impl;

import com.heights.auditapp.controller.AuditScopeApproavalController;
import com.heights.auditapp.dto.AuditScopeApproavalDTO;
import com.heights.auditapp.mapper.AuditScopeApproavalMapper;
import com.heights.auditapp.model.AuditScopeApproaval;
import com.heights.auditapp.service.AuditScopeApproavalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/audit-scope-approaval")
@RestController
public class AuditScopeApproavalControllerImpl implements AuditScopeApproavalController {
    private final AuditScopeApproavalService auditScopeApproavalService;
    private final AuditScopeApproavalMapper auditScopeApproavalMapper;

    public AuditScopeApproavalControllerImpl(AuditScopeApproavalService auditScopeApproavalService, AuditScopeApproavalMapper auditScopeApproavalMapper) {
        this.auditScopeApproavalService = auditScopeApproavalService;
        this.auditScopeApproavalMapper = auditScopeApproavalMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuditScopeApproavalDTO save(@RequestBody AuditScopeApproavalDTO auditScopeApproavalDTO) {
        AuditScopeApproaval auditScopeApproaval = auditScopeApproavalMapper.asEntity(auditScopeApproavalDTO);
        return auditScopeApproavalMapper.asDTO(auditScopeApproavalService.save(auditScopeApproaval));
    }

    @Override
    @GetMapping("/{id}")
    public AuditScopeApproavalDTO findById(@PathVariable("id") Long id) {
        AuditScopeApproaval auditScopeApproaval = auditScopeApproavalService.findById(id).orElse(null);
        return auditScopeApproavalMapper.asDTO(auditScopeApproaval);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        auditScopeApproavalService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<AuditScopeApproavalDTO> list() {
        return auditScopeApproavalMapper.asDTOList(auditScopeApproavalService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<AuditScopeApproavalDTO> pageQuery(Pageable pageable) {
        Page<AuditScopeApproaval> auditScopeApproavalPage = auditScopeApproavalService.findAll(pageable);
        List<AuditScopeApproavalDTO> dtoList = auditScopeApproavalPage
                .stream()
                .map(auditScopeApproavalMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, auditScopeApproavalPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public AuditScopeApproavalDTO update(@RequestBody AuditScopeApproavalDTO auditScopeApproavalDTO, @PathVariable("id") Long id) {
        AuditScopeApproaval auditScopeApproaval = auditScopeApproavalMapper.asEntity(auditScopeApproavalDTO);
        return auditScopeApproavalMapper.asDTO(auditScopeApproavalService.update(auditScopeApproaval, id));
    }
}