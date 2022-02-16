package com.heights.auditapp.controller.impl;

import com.heights.auditapp.controller.AuditFocusProceduresController;
import com.heights.auditapp.dto.AuditFocusProceduresDTO;
import com.heights.auditapp.mapper.AuditFocusProceduresMapper;
import com.heights.auditapp.model.AuditFocusProcedures;
import com.heights.auditapp.service.AuditFocusProceduresService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/audit-procedures")
@Controller
public class AuditFocusProceduresControllerImpl implements AuditFocusProceduresController {
    private final AuditFocusProceduresService auditFocusProceduresService;
    private final AuditFocusProceduresMapper auditFocusProceduresMapper;

    public AuditFocusProceduresControllerImpl(AuditFocusProceduresService auditFocusProceduresService, AuditFocusProceduresMapper auditFocusProceduresMapper) {
        this.auditFocusProceduresService = auditFocusProceduresService;
        this.auditFocusProceduresMapper = auditFocusProceduresMapper;
    }

    @Override
    @PostMapping
    public AuditFocusProceduresDTO save(@ModelAttribute AuditFocusProceduresDTO auditFocusProcedure) {
        AuditFocusProcedures auditFocusProcedures = auditFocusProceduresMapper.asEntity(auditFocusProcedure);
        return auditFocusProceduresMapper.asDTO(auditFocusProceduresService.save(auditFocusProcedures));
    }

    @Override
    @PostMapping
    public List<AuditFocusProceduresDTO> save(@ModelAttribute List<AuditFocusProceduresDTO> auditFocusProceduresDTO) {
        List<AuditFocusProcedures> auditFocusProcedures = auditFocusProceduresMapper.asEntityList(auditFocusProceduresDTO);
        return auditFocusProceduresMapper.asDTOList(auditFocusProceduresService.save(auditFocusProcedures));
    }

    @Override
    @GetMapping("/{id}")
    public AuditFocusProceduresDTO findById(@PathVariable("id") Long id) {
        AuditFocusProcedures auditFocusProcedures = auditFocusProceduresService.findById(id).orElse(null);
        return auditFocusProceduresMapper.asDTO(auditFocusProcedures);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        auditFocusProceduresService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<AuditFocusProceduresDTO> list() {
        return auditFocusProceduresMapper.asDTOList(auditFocusProceduresService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<AuditFocusProceduresDTO> pageQuery(Pageable pageable) {
        Page<AuditFocusProcedures> auditFocusProceduresPage = auditFocusProceduresService.findAll(pageable);
        List<AuditFocusProceduresDTO> dtoList = auditFocusProceduresPage
                .stream()
                .map(auditFocusProceduresMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, auditFocusProceduresPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public AuditFocusProceduresDTO update(@RequestBody AuditFocusProceduresDTO auditFocusProceduresDTO, @PathVariable("id") Long id) {
        AuditFocusProcedures auditFocusProcedures = auditFocusProceduresMapper.asEntity(auditFocusProceduresDTO);
        return auditFocusProceduresMapper.asDTO(auditFocusProceduresService.update(auditFocusProcedures, id));
    }
}