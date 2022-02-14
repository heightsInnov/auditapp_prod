package com.heights.auditapp.controller.impl;

import com.heights.auditapp.dto.AuditFocusDTO;
import com.heights.auditapp.mapper.AuditFocusMapper;
import com.heights.auditapp.model.AuditFocus;
import com.heights.auditapp.service.AuditFocusService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String save(@ModelAttribute AuditFocusDTO auditFocusDTO, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        if(session.getAttribute("userId") == null){
            return "redirect:/";
        }
        auditFocusDTO.setUserId(Long.parseLong(session.getAttribute("userId").toString()));
        AuditFocus auditFocus = auditFocusMapper.asEntity(auditFocusDTO);
        AuditFocusDTO  auditFocusDTO1 =  auditFocusMapper.asDTO(auditFocusService.save(auditFocus));
        if(auditFocusDTO1 != null)
            model.addAttribute("message", "Focus successfully created");
        else
            model.addAttribute("message", "Error creating focus, kindly check and try again");

        return "redirect:/audit-scope/preview/"+auditFocusDTO.getScopeId();
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