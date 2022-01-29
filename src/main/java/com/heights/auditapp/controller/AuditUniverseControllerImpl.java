package com.heights.auditapp.controller;

import com.heights.auditapp.dto.AuditUniverseDTO;
import com.heights.auditapp.mapper.AuditUniverseMapper;
import com.heights.auditapp.model.AuditUniverseEntity;
import com.heights.auditapp.service.AuditUniverseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/audit-universe")
@RestController
public class AuditUniverseControllerImpl {
    private final AuditUniverseService auditUniverseService;
    private final AuditUniverseMapper auditUniverseMapper;

    public AuditUniverseControllerImpl(AuditUniverseService auditUniverseService, AuditUniverseMapper auditUniverseMapper) {
        this.auditUniverseService = auditUniverseService;
        this.auditUniverseMapper = auditUniverseMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuditUniverseDTO save(@RequestBody AuditUniverseDTO auditUniverseDTO) {
        AuditUniverseEntity auditUniverse = auditUniverseMapper.asEntity(auditUniverseDTO);
        return auditUniverseMapper.asDTO(auditUniverseService.save(auditUniverse));
    }

    @GetMapping("/{id}")
    public AuditUniverseDTO findById(@PathVariable("id") Long id) {
        AuditUniverseEntity auditUniverse = auditUniverseService.findById(id).orElse(null);
        return auditUniverseMapper.asDTO(auditUniverse);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        auditUniverseService.deleteById(id);
    }

    @GetMapping
    public List<AuditUniverseDTO> list() {
        return auditUniverseMapper.asDTOList(auditUniverseService.findAll());
    }

    @GetMapping("/page-query")
    public Page<AuditUniverseDTO> pageQuery(Pageable pageable) {
        Page<AuditUniverseEntity> auditUniversePage = auditUniverseService.findAll(pageable);
        List<AuditUniverseDTO> dtoList = auditUniversePage
                .stream()
                .map(auditUniverseMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, auditUniversePage.getTotalElements());
    }

    @PutMapping("/{id}")
    public AuditUniverseDTO update(@RequestBody AuditUniverseDTO auditUniverseDTO, @PathVariable("id") Long id) {
        AuditUniverseEntity auditUniverse = auditUniverseMapper.asEntity(auditUniverseDTO);
        return auditUniverseMapper.asDTO(auditUniverseService.update(auditUniverse, id));
    }
}