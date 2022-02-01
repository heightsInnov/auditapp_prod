package com.heights.auditapp.controller.impl;

import com.heights.auditapp.dto.AuditDTO;
import com.heights.auditapp.mapper.AuditMapper;
import com.heights.auditapp.model.AuditEntity;
import com.heights.auditapp.service.AuditEntityService;
import com.heights.auditapp.service.AuditUniverseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/audit-entity")
@Controller
public class AuditEntityControllerImpl {
    private final AuditEntityService auditEntityService;
    private final AuditMapper auditMapper;
    private final AuditUniverseService auditUniverseService;

    public AuditEntityControllerImpl(AuditEntityService auditEntityService, AuditMapper auditMapper, AuditUniverseService auditUniverseService) {
        this.auditEntityService = auditEntityService;
        this.auditMapper = auditMapper;
        this.auditUniverseService = auditUniverseService;
    }

    @GetMapping("/index")
    public String load(Model model){
        model.addAttribute("universe", auditUniverseService.findAll());
        return "entity";
    }
    @PostMapping("add-entity")
    @ResponseStatus(HttpStatus.CREATED)
    public AuditDTO save(@RequestBody AuditDTO auditEntityDTO) {
        AuditEntity audit = auditMapper.asEntity(auditEntityDTO);
        return auditMapper.asDTO(auditEntityService.save(audit));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        auditEntityService.deleteById(id);
    }

    @GetMapping("/{id}")
    public AuditDTO findById(@PathVariable("id") Long id) {
        AuditEntity audit = auditEntityService.findById(id).orElse(null);
        return auditMapper.asDTO(audit);
    }

    @GetMapping
    public List<AuditDTO> list() {
        return auditMapper.asDTOList(auditEntityService.findAll());
    }

    @GetMapping("/page-query")
    public Page<AuditDTO> pageQuery(Pageable pageable) {
        Page<AuditEntity> auditPage = auditEntityService.findAll(pageable);
        List<AuditDTO> dtoList = auditPage
                .stream()
                .map(auditMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, auditPage.getTotalElements());
    }

    @PutMapping("/{id}")
    public AuditDTO update(@RequestBody AuditDTO auditEntityDTO, @PathVariable("id") Long id) {
        AuditEntity audit = auditMapper.asEntity(auditEntityDTO);
        return auditMapper.asDTO(auditEntityService.update(audit, id));
    }

    @GetMapping("/{universeId}")
    public List<AuditDTO> findByUniverse(@PathVariable Long universeId) {
        return auditMapper.asDTOList(auditEntityService.findEntitiesByUniverseId(universeId));
    }
}