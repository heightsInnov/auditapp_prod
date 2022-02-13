package com.heights.auditapp.controller.impl;

import com.heights.auditapp.dto.AuditFocusDTO;
import com.heights.auditapp.mapper.AuditFocusMapper;
import com.heights.auditapp.model.AuditFocus;
import com.heights.auditapp.service.AuditFocusService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/audit-focus")
@Controller
public class AuditFocusControllerImpl {
    private final AuditFocusService auditFocusService;
    private final AuditFocusMapper auditFocusMapper;

    public AuditFocusControllerImpl(AuditFocusService auditFocusService, AuditFocusMapper auditFocusMapper) {
        this.auditFocusService = auditFocusService;
        this.auditFocusMapper = auditFocusMapper;
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AuditFocusDTO save(@RequestBody AuditFocusDTO auditFocusDTO) {
        AuditFocus auditFocus = auditFocusMapper.asEntity(auditFocusDTO);
        return auditFocusMapper.asDTO(auditFocusService.save(auditFocus));
    }


    @GetMapping("/{id}")
    public AuditFocusDTO findById(@PathVariable("id") Long id) {
        AuditFocus auditFocus = auditFocusService.findById(id).orElse(null);
        return auditFocusMapper.asDTO(auditFocus);
    }


    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return auditFocusService.deleteByDtoId(id);
    }


    @GetMapping
    public List<AuditFocusDTO> list() {
        return auditFocusMapper.asDTOList(auditFocusService.findAll());
    }


    @GetMapping("/page-query")
    public Page<AuditFocusDTO> pageQuery(Pageable pageable) {
        Page<AuditFocus> auditFocusPage = auditFocusService.findAll(pageable);
        List<AuditFocusDTO> dtoList = auditFocusPage
                .stream()
                .map(auditFocusMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, auditFocusPage.getTotalElements());
    }


    @PutMapping("/{id}")
    public AuditFocusDTO update(@RequestBody AuditFocusDTO auditFocusDTO, @PathVariable("id") Long id) {
        AuditFocus auditFocus = auditFocusMapper.asEntity(auditFocusDTO);
        return auditFocusMapper.asDTO(auditFocusService.update(auditFocus, id));
    }

    @GetMapping("/execute")
    public String auditExecution(){
        return "execution";
    }
}