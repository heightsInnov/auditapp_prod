package com.heights.auditapp.controller.impl;

import com.heights.auditapp.controller.AuditScopeEntityController;
import com.heights.auditapp.dto.AuditScopeDTO;
import com.heights.auditapp.mapper.AuditScopeMapper;
import com.heights.auditapp.model.AuditScopeEntity;
import com.heights.auditapp.service.AuditScopeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/audit-scope")
@RestController
public class AuditScopeControllerImpl implements AuditScopeEntityController {
    private final AuditScopeService auditScopeService;
    private final AuditScopeMapper auditScopeMapper;

    public AuditScopeControllerImpl(AuditScopeService auditScopeService, AuditScopeMapper auditScopeMapper) {
        this.auditScopeService = auditScopeService;
        this.auditScopeMapper = auditScopeMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuditScopeDTO save(@RequestBody AuditScopeDTO auditScopeDTO) {
        AuditScopeEntity auditScope = auditScopeMapper.asEntity(auditScopeDTO);
        return auditScopeMapper.asDTO(auditScopeService.save(auditScope));
    }

    @Override
    @GetMapping("/{id}")
    public AuditScopeDTO findById(@PathVariable("id") BigInteger id) {
        AuditScopeEntity auditScope = auditScopeService.findById(id).orElse(null);
        return auditScopeMapper.asDTO(auditScope);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") BigInteger id) {
        auditScopeService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<AuditScopeDTO> list() {
        return auditScopeMapper.asDTOList(auditScopeService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<AuditScopeDTO> pageQuery(Pageable pageable) {
        Page<AuditScopeEntity> auditScopePage = auditScopeService.findAll(pageable);
        List<AuditScopeDTO> dtoList = auditScopePage
                .stream()
                .map(auditScopeMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, auditScopePage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public AuditScopeDTO update(@RequestBody AuditScopeDTO auditScopeDTO, @PathVariable("id") BigInteger id) {
        AuditScopeEntity auditScope = auditScopeMapper.asEntity(auditScopeDTO);
        return auditScopeMapper.asDTO(auditScopeService.update(auditScope, id));
    }
}