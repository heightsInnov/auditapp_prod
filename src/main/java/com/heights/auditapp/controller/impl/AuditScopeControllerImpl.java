package com.heights.auditapp.controller.impl;

import com.heights.auditapp.dto.AuditScopeDTO;
import com.heights.auditapp.mapper.AuditScopeMapper;
import com.heights.auditapp.model.AuditScope;
import com.heights.auditapp.service.AuditScopeService;
import com.heights.auditapp.service.AuditService;
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

@RequestMapping("/audit-scope")
@Controller
public class AuditScopeControllerImpl {
    private final AuditScopeService auditScopeService;
    private final AuditScopeMapper auditScopeMapper;
    private final AuditUniverseService auditUniverseService;
    private final AuditService auditService;

    public AuditScopeControllerImpl(AuditScopeService auditScopeService, AuditScopeMapper auditScopeMapper, AuditUniverseService auditUniverseService, AuditService auditService) {
        this.auditScopeService = auditScopeService;
        this.auditScopeMapper = auditScopeMapper;
        this.auditUniverseService = auditUniverseService;
        this.auditService = auditService;
    }

    @GetMapping("/index")
    public String load(Model model){
        model.addAttribute("universe", auditUniverseService.findAll());
        return "scope";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("universe", auditUniverseService.findAll());
        model.addAttribute("scope", new AuditScopeDTO());
        return "create-scope";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuditScopeDTO save(@RequestBody AuditScopeDTO auditScopeDTO) {
        AuditScope auditScope = auditScopeMapper.asEntity(auditScopeDTO);
        return auditScopeMapper.asDTO(auditScopeService.save(auditScope));
    }


    @GetMapping("/{id}")
    public AuditScopeDTO findById(@PathVariable("id") Long id) {
        AuditScope auditScope = auditScopeService.findById(id).orElse(null);
        return auditScopeMapper.asDTO(auditScope);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        auditScopeService.deleteById(id);
    }


    @GetMapping
    public List<AuditScopeDTO> list() {
        return auditScopeMapper.asDTOList(auditScopeService.findAll());
    }


    @GetMapping("/page-query")
    public Page<AuditScopeDTO> pageQuery(Pageable pageable) {
        Page<AuditScope> auditScopePage = auditScopeService.findAll(pageable);
        List<AuditScopeDTO> dtoList = auditScopePage
                .stream()
                .map(auditScopeMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, auditScopePage.getTotalElements());
    }


    @PutMapping("/{id}")
    public AuditScopeDTO update(@RequestBody AuditScopeDTO auditScopeDTO, @PathVariable("id") Long id) {
        AuditScope auditScope = auditScopeMapper.asEntity(auditScopeDTO);
        return auditScopeMapper.asDTO(auditScopeService.update(auditScope, id));
    }
}