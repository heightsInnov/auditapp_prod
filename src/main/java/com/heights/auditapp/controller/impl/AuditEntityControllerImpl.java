package com.heights.auditapp.controller.impl;

import com.heights.auditapp.controller.AuditEntityEntityController;
import com.heights.auditapp.dto.AuditEntityDTO;
import com.heights.auditapp.mapper.AuditEntityMapper;
import com.heights.auditapp.model.AuditEntityEntity;
import com.heights.auditapp.service.AuditEntityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/audit")
@RestController
public class AuditEntityControllerImpl implements AuditEntityEntityController {
    private final AuditEntityService auditEntityService;
    private final AuditEntityMapper auditMapper;

    public AuditEntityControllerImpl(AuditEntityService auditEntityService, AuditEntityMapper auditMapper) {
        this.auditEntityService = auditEntityService;
        this.auditMapper = auditMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuditEntityDTO save(@RequestBody AuditEntityDTO auditEntityDTO) {
        AuditEntityEntity audit = auditMapper.asEntity(auditEntityDTO);
        return auditMapper.asDTO(auditEntityService.save(audit));
    }

    @Override
    @GetMapping("/{id}")
    public AuditEntityDTO findById(@PathVariable("id") BigInteger id) {
        AuditEntityEntity audit = auditEntityService.findById(id).orElse(null);
        return auditMapper.asDTO(audit);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") BigInteger id) {
        auditEntityService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<AuditEntityDTO> list() {
        return auditMapper.asDTOList(auditEntityService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<AuditEntityDTO> pageQuery(Pageable pageable) {
        Page<AuditEntityEntity> auditPage = auditEntityService.findAll(pageable);
        List<AuditEntityDTO> dtoList = auditPage
                .stream()
                .map(auditMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, auditPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public AuditEntityDTO update(@RequestBody AuditEntityDTO auditEntityDTO, @PathVariable("id") BigInteger id) {
        AuditEntityEntity audit = auditMapper.asEntity(auditEntityDTO);
        return auditMapper.asDTO(auditEntityService.update(audit, id));
    }
}