package com.heights.auditapp.controller.impl;

import com.heights.auditapp.dto.AuditDTO;
import com.heights.auditapp.mapper.AuditMapper;
import com.heights.auditapp.model.AuditEntity;
import com.heights.auditapp.service.AuditEntityService;
import com.heights.auditapp.service.AuditUniverseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

    @GetMapping
    public String load(Model model){
        model.addAttribute("universe", auditUniverseService.findAll());
        model.addAttribute("entityObj", new AuditDTO());
        return "entity";
    }

    @PostMapping
    public String save(@ModelAttribute("entityObj") AuditDTO auditEntityDTO, Model model) {
        if(auditEntityDTO.getUniverseId() < 1){
            model.addAttribute("message", "No universe selected");
        }

        AuditEntity audit = auditMapper.asEntity(auditEntityDTO);
        auditMapper.asDTO(auditEntityService.save(audit));
        return "redirect:/audit-entity/get-by-universe/"+ auditEntityDTO.getUniverseId();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return auditEntityService.deleteByDtoId(id);
    }

    @GetMapping("/{id}")
    public @ResponseBody AuditDTO findById(@PathVariable("id") Long id) {
        AuditEntity audit = auditEntityService.findById(id).orElse(null);
        return auditMapper.asDTO(audit);
    }

    @GetMapping("/get-all")
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

    @GetMapping("/get-by-universe/{universeId}")
    public String findByUniverse(@PathVariable Long universeId, Model model) {
        model.addAttribute("entities", auditMapper.asDTOList(auditEntityService.findEntitiesByUniverseId(universeId)));
        model.addAttribute("entityObj", new AuditDTO());
        model.addAttribute("universe", auditUniverseService.findAll());
        return "entity";
    }

    @GetMapping("/get-by-universeId/{universeId}")
    public @ResponseBody List<AuditDTO> findByUniverseId(@PathVariable Long universeId, Model model) {
        return auditMapper.asDTOList(auditEntityService.findEntitiesByUniverseId(universeId));
    }
}