package com.heights.auditapp.controller.impl;

import com.heights.auditapp.controller.AuditScopeApproavalController;
import com.heights.auditapp.dto.AuditScopeApproavalDTO;
import com.heights.auditapp.dto.AuditScopeDTO;
import com.heights.auditapp.mapper.AuditScopeMapper;
import com.heights.auditapp.model.AuditScope;
import com.heights.auditapp.service.AuditScopeService;
import com.heights.auditapp.service.AuditUniverseService;
import com.heights.auditapp.service.AuditUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
    private final AuditScopeApproavalController auditScopeApproaval;
    private final AuditUserService auditUserService;

    public AuditScopeControllerImpl(AuditScopeService auditScopeService, AuditScopeMapper auditScopeMapper, AuditUniverseService auditUniverseService,
                                    AuditScopeApproavalController auditScopeApproaval, AuditUserService auditUserService) {
        this.auditScopeService = auditScopeService;
        this.auditScopeMapper = auditScopeMapper;
        this.auditUniverseService = auditUniverseService;
        this.auditScopeApproaval = auditScopeApproaval;
        this.auditUserService = auditUserService;
    }

    @GetMapping
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

    @PostMapping(value="/save", params="action=approve")
    public String sendForApproval(@ModelAttribute("scope") AuditScopeDTO auditScopeDTO, Model model) {
        AuditScope auditScope = auditScopeMapper.asEntity(auditScopeDTO);
        AuditScopeApproavalDTO approval = new AuditScopeApproavalDTO();
        approval.setScopeId(auditScopeDTO.getScopeId());
        approval.setUserId(auditUserService.findByUsername(auditScope.getUserName()).getUserId());
        model.addAttribute("response",auditScopeApproaval.save(approval));
        return "redirect:/audit-scope";
    }

    @PostMapping(value="/save", params="action=save")
    public String save(@ModelAttribute("scope") AuditScopeDTO auditScopeDTO, Model model) {
        AuditScope auditScope = auditScopeMapper.asEntity(auditScopeDTO);
        model.addAttribute("response", auditScopeMapper.asDTO(auditScopeService.save(auditScope)));
        return "create-scope";
    }


    @GetMapping("/{id}")
    public AuditScopeDTO findById(@PathVariable("id") Long id) {
        AuditScope auditScope = auditScopeService.findById(id).orElse(null);
        return auditScopeMapper.asDTO(auditScope);
    }


    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return auditScopeService.deleteByDtoId(id);
    }


    @GetMapping("/get-all")
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