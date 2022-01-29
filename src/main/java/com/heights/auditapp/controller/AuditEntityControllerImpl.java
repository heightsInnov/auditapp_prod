package com.heights.auditapp.controller;

import com.heights.auditapp.dto.AuditEntityDTO;
import com.heights.auditapp.mapper.AuditEntityMapper;
import com.heights.auditapp.model.AuditEntityEntity;
import com.heights.auditapp.service.AuditEntityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/audit-entity")
@RestController
public class AuditEntityControllerImpl {
    private final AuditEntityService auditEntityService;
    private final AuditEntityMapper auditMapper;

    public AuditEntityControllerImpl(AuditEntityService auditEntityService, AuditEntityMapper auditMapper) {
        this.auditEntityService = auditEntityService;
        this.auditMapper = auditMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuditEntityDTO save(@RequestBody AuditEntityDTO auditEntityDTO) {
        AuditEntityEntity audit = auditMapper.asEntity(auditEntityDTO);
        return auditMapper.asDTO(auditEntityService.save(audit));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        auditEntityService.deleteById(id);
    }

    @GetMapping("/{id}")
    public AuditEntityDTO findById(@PathVariable("id") Long id) {
        AuditEntityEntity audit = auditEntityService.findById(id).orElse(null);
        return auditMapper.asDTO(audit);
    }

    @GetMapping
    public List<AuditEntityDTO> list() {
        return auditMapper.asDTOList(auditEntityService.findAll());
    }

    @GetMapping("/page-query")
    public Page<AuditEntityDTO> pageQuery(Pageable pageable) {
        Page<AuditEntityEntity> auditPage = auditEntityService.findAll(pageable);
        List<AuditEntityDTO> dtoList = auditPage
                .stream()
                .map(auditMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, auditPage.getTotalElements());
    }

    @PutMapping("/{id}")
    public AuditEntityDTO update(@RequestBody AuditEntityDTO auditEntityDTO, @PathVariable("id") Long id) {
        AuditEntityEntity audit = auditMapper.asEntity(auditEntityDTO);
        return auditMapper.asDTO(auditEntityService.update(audit, id));
    }

    @GetMapping("/{universeId}")
    public List<AuditEntityDTO> findByUniverse(@PathVariable Long universeId) {
        return auditMapper.asDTOList(auditEntityService.findEntitiesByUniverseId(universeId));
    }
}