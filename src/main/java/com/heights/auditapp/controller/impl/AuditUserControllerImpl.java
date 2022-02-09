package com.heights.auditapp.controller.impl;

import com.heights.auditapp.dto.AuditUserDTO;
import com.heights.auditapp.mapper.AuditRoleMapper;
import com.heights.auditapp.mapper.AuditUserMapper;
import com.heights.auditapp.model.AuditUser;
import com.heights.auditapp.service.AuditRoleService;
import com.heights.auditapp.service.AuditUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/audit-user")
@Controller
public class AuditUserControllerImpl{
    private final AuditUserService auditUserService;
    private final AuditRoleService auditRoleService;
    private final AuditUserMapper auditUserMapper;
    private final AuditRoleMapper auditRoleMapper;

    public AuditUserControllerImpl(AuditUserService auditUserService, AuditRoleService auditRoleService, AuditUserMapper auditUserMapper, AuditRoleMapper auditRoleMapper) {
        this.auditUserService = auditUserService;
        this.auditRoleService = auditRoleService;
        this.auditUserMapper = auditUserMapper;
        this.auditRoleMapper = auditRoleMapper;
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
        model.addAttribute("role", auditRoleService.findAll());
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
    public String login(AuditUserDTO dto, Model model, RedirectAttributes redirect, HttpSession session) {
        if(dto.getUsername().equals("") || dto.getPassword().equals("")){
            model.addAttribute("message", "Invalid username or Password");
            return "redirect:/";
        }
        AuditUser tt = auditUserService.login(dto.getUsername(), dto.getPassword());

        if (tt != null) {
            AuditUserDTO auditUserDTO = auditUserMapper.asDTO(tt);
            session.setAttribute("username", auditUserDTO.getUsername());
            session.setAttribute("role", auditUserDTO.getRole());
            return  "redirect:/dashboard";
        }
        redirect.addFlashAttribute("message", "Invalid username or password");
        return "redirect:/";
    }
}