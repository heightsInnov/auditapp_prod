package com.heights.auditapp.controller.impl;

import com.heights.auditapp.dto.AuditUniverseDTO;
import com.heights.auditapp.mapper.AuditUniverseMapper;
import com.heights.auditapp.model.AuditUniverse;
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

@RequestMapping("/audit-universe")
@Controller
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
        AuditUniverse auditUniverse = auditUniverseMapper.asEntity(auditUniverseDTO);
        return auditUniverseMapper.asDTO(auditUniverseService.save(auditUniverse));
    }

    @GetMapping("/{id}")
    public AuditUniverseDTO findById(@PathVariable("id") Long id) {
        AuditUniverse auditUniverse = auditUniverseService.findById(id).orElse(null);
        return auditUniverseMapper.asDTO(auditUniverse);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        auditUniverseService.deleteById(id);
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("universe", auditUniverseMapper.asDTOList(auditUniverseService.findAll()));
        return "universe";
    }

    @GetMapping("/page-query")
    public Page<AuditUniverseDTO> pageQuery(Pageable pageable) {
        Page<AuditUniverse> auditUniversePage = auditUniverseService.findAll(pageable);
        List<AuditUniverseDTO> dtoList = auditUniversePage
                .stream()
                .map(auditUniverseMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, auditUniversePage.getTotalElements());
    }

    @PutMapping("/{id}")
    public AuditUniverseDTO update(@RequestBody AuditUniverseDTO auditUniverseDTO, @PathVariable("id") Long id) {
        AuditUniverse auditUniverse = auditUniverseMapper.asEntity(auditUniverseDTO);
        return auditUniverseMapper.asDTO(auditUniverseService.update(auditUniverse, id));
    }
}