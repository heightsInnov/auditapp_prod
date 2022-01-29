package com.heights.auditapp.controller;

import com.heights.auditapp.dto.AuditFocusDTO;
import com.heights.auditapp.mapper.AuditFocusMapper;
import com.heights.auditapp.model.AuditFocusEntity;
import com.heights.auditapp.service.AuditFocusService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/audit-focus")
@RestController
public class AuditFocusControllerImpl {
    private final AuditFocusService auditFocusService;
    private final AuditFocusMapper auditFocusMapper;

    public AuditFocusControllerImpl(AuditFocusService auditFocusService, AuditFocusMapper auditFocusMapper) {
        this.auditFocusService = auditFocusService;
        this.auditFocusMapper = auditFocusMapper;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuditFocusDTO save(@RequestBody AuditFocusDTO auditFocusDTO) {
        AuditFocusEntity auditFocus = auditFocusMapper.asEntity(auditFocusDTO);
        return auditFocusMapper.asDTO(auditFocusService.save(auditFocus));
    }


    @GetMapping("/{id}")
    public AuditFocusDTO findById(@PathVariable("id") Long id) {
        AuditFocusEntity auditFocus = auditFocusService.findById(id).orElse(null);
        return auditFocusMapper.asDTO(auditFocus);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        auditFocusService.deleteById(id);
    }


    @GetMapping
    public List<AuditFocusDTO> list() {
        return auditFocusMapper.asDTOList(auditFocusService.findAll());
    }


    @GetMapping("/page-query")
    public Page<AuditFocusDTO> pageQuery(Pageable pageable) {
        Page<AuditFocusEntity> auditFocusPage = auditFocusService.findAll(pageable);
        List<AuditFocusDTO> dtoList = auditFocusPage
                .stream()
                .map(auditFocusMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, auditFocusPage.getTotalElements());
    }


    @PutMapping("/{id}")
    public AuditFocusDTO update(@RequestBody AuditFocusDTO auditFocusDTO, @PathVariable("id") Long id) {
        AuditFocusEntity auditFocus = auditFocusMapper.asEntity(auditFocusDTO);
        return auditFocusMapper.asDTO(auditFocusService.update(auditFocus, id));
    }
}