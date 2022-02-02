package com.heights.auditapp.controller.impl;

import com.heights.auditapp.dto.AuditUserDTO;
import com.heights.auditapp.mapper.AuditUserMapper;
import com.heights.auditapp.model.AuditUser;
import com.heights.auditapp.service.AuditUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/audit-user")
@Controller
public class AuditUserControllerImpl{
    private final AuditUserService auditUserService;
    private final AuditUserMapper auditUserMapper;

    public AuditUserControllerImpl(AuditUserService auditUserService, AuditUserMapper auditUserMapper) {
        this.auditUserService = auditUserService;
        this.auditUserMapper = auditUserMapper;
    }

    
    @PostMapping
    public String save(AuditUserDTO auditUserDTO, Model model) {
        AuditUser auditUser = auditUserMapper.asEntity(auditUserDTO);
        model.addAttribute(auditUserMapper.asDTO(auditUserService.save(auditUser)));
        return "redirect:/audit-user";
    }

    
    @GetMapping("/{id}")
    public AuditUserDTO findById(@PathVariable("id") Long id) {
        AuditUser auditUser = auditUserService.findById(id).orElse(null);
        return auditUserMapper.asDTO(auditUser);
    }

    
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return auditUserService.deleteByDtoId(id);
    }

    
    @GetMapping
    public String list(Model model) {
        model.addAttribute("users", auditUserMapper.asDTOList(auditUserService.findAll()));
        model.addAttribute("user", new AuditUserDTO());
        return "user";
    }

    
    @GetMapping("/page-query")
    public Page<AuditUserDTO> pageQuery(Pageable pageable) {
        Page<AuditUser> auditUserPage = auditUserService.findAll(pageable);
        List<AuditUserDTO> dtoList = auditUserPage
                .stream()
                .map(auditUserMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, auditUserPage.getTotalElements());
    }

    
    @PutMapping("/{id}")
    public AuditUserDTO update(@RequestBody AuditUserDTO auditUserDTO, @PathVariable("id") Long id) {
        AuditUser auditUser = auditUserMapper.asEntity(auditUserDTO);
        return auditUserMapper.asDTO(auditUserService.update(auditUser, id));
    }

    @PostMapping("/login")
    public RedirectView login(AuditUserDTO dto, Model model, RedirectAttributes redir) {
        if(dto.getUsername() == null || dto.getPassword() == null){
            model.addAttribute("message", "Invalid username or Password");
        }
        AuditUserDTO auditUserDTO = auditUserMapper.asDTO(auditUserService.login(dto.getUsername(), dto.getPassword()));
        RedirectView redirectView;
        if (auditUserDTO != null) {
            redirectView = new RedirectView("/dashboard", true);
            redir.addFlashAttribute("USERNAME", auditUserDTO.getUsername());
            redir.addFlashAttribute("ROLE", auditUserDTO.getRole());
        }
        redirectView = new RedirectView("/audit-user", true);
        return redirectView;
    }
}