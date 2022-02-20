package com.heights.auditapp.controller.impl;

import com.heights.auditapp.dto.AuditFocusDTO;
import com.heights.auditapp.dto.AuditFocusProceduresDTO;
import com.heights.auditapp.mapper.AuditFocusMapper;
import com.heights.auditapp.mapper.AuditFocusProceduresMapper;
import com.heights.auditapp.model.Approval_Status;
import com.heights.auditapp.model.AuditFocus;
import com.heights.auditapp.model.AuditScope;
import com.heights.auditapp.service.AuditFocusProceduresService;
import com.heights.auditapp.service.AuditFocusService;
import com.heights.auditapp.service.AuditScopeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/audit-focus")
@Controller
public class AuditFocusControllerImpl {
    private final AuditFocusService auditFocusService;
    private final AuditFocusMapper auditFocusMapper;
    private final AuditFocusProceduresMapper auditFocusProceduresMapper;
    private final AuditScopeService auditScopeService;
    private final AuditFocusProceduresService auditFocusProceduresService;

    public AuditFocusControllerImpl(AuditFocusService auditFocusService, AuditFocusMapper auditFocusMapper, AuditFocusProceduresMapper auditFocusProceduresMapper, AuditScopeService auditScopeService, AuditFocusProceduresService auditFocusProceduresService) {
        this.auditFocusService = auditFocusService;
        this.auditFocusMapper = auditFocusMapper;
        this.auditFocusProceduresMapper = auditFocusProceduresMapper;
        this.auditScopeService = auditScopeService;
        this.auditFocusProceduresService = auditFocusProceduresService;
    }


    @PostMapping("/save")
    public String save(@ModelAttribute AuditFocusDTO auditFocusDTO, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        }
        auditFocusDTO.setUserId(Long.parseLong(session.getAttribute("userId").toString()));
        auditScopeService
                .findById(auditFocusDTO.getScopeId())
                .ifPresent(auditScope -> auditFocusDTO.setSchedulledDate(auditScope.getAuditStartDate()));
        AuditFocus auditFocus = auditFocusMapper.asEntity(auditFocusDTO);
        AuditFocusDTO auditFocusDTO1 = auditFocusMapper.asDTO(auditFocusService.save(auditFocus));
        if (auditFocusDTO1 != null)
            model.addAttribute("message", "Focus successfully created");
        else
            model.addAttribute("message", "Error creating focus, kindly check and try again");

        return "redirect:/audit-scope/preview/" + auditFocusDTO.getScopeId();
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

    @GetMapping("/execute-list/{scopeId}")
    public String auditExecution(Model model, @PathVariable long scopeId, @Nullable @RequestParam("scopatunama") String title) {
        List<AuditFocusDTO> auditFocus = auditFocusMapper.asDTOList(auditFocusService.findAuditFocusByScope(scopeId));
        List<AuditFocusProceduresDTO> procedures = auditFocusProceduresMapper.asDTOList(auditFocusProceduresService.findAll());
        for (AuditFocusDTO focus : auditFocus) {
            long procCount = procedures.stream().filter(x -> x.getFocusId().equals(focus.getId())).count();
            focus.setProcedureCount((int)procCount);
            if(procCount > 0) {
                long compCount = procedures.stream().filter(x -> x.getFocusId().equals(focus.getId()) && x.getStatus().equals(Approval_Status.COMPLETED)).count();
                Long cc = (compCount*100)/procCount;
                focus.setProgressLevel(compCount > 0 ? cc.intValue() : 0);
            }
        }
        model.addAttribute("foci", auditFocus);
        model.addAttribute("title", title);
        return "execution-focus";
    }

    @GetMapping("/execute/{focusId}")
    public String startExecution(@PathVariable long focusId, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        HttpSession session = request.getSession();
        try{
            Optional<AuditFocus> focus = auditFocusService.findById(focusId);
            if(!focus.isPresent()){
                redirectAttributes.addFlashAttribute("message", "Invalid audit focus id selected");
                return "redirect:/audit-scope/execute/"+session.getAttribute("universe").toString();
            }
            else {
                AuditFocus auditFocus = focus.get();
                AuditScope scope = new AuditScope();
                Optional<AuditScope> scopeEntity = auditScopeService.findById(auditFocus.getScopeId());
                if(scopeEntity.isPresent()) scope = scopeEntity.get();
                if(auditFocus.getSchedulledDate().isAfter(LocalDate.now())){
                    redirectAttributes.addFlashAttribute("message", "Audit focus cannot be started before the scheduled date");
                }else{
                    auditFocus.setStartDate(LocalDate.now());
                    auditFocus.setApprovalStatus(Approval_Status.ACTIVE.name());
                    auditFocus.setStartFlag("none");
                    auditFocus.setStartedBy(session.getAttribute("username").toString());
                    auditFocusService.save(auditFocus);
                    redirectAttributes.addFlashAttribute("message", "Audit focus started successfully");
                }
                return "redirect:/audit-focus/execute-list/"+auditFocus.getScopeId()+"?scopatunama="+ scope.getScopeOfAudit();
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return "redirect:/audit-scope/execute/"+session.getAttribute("universe").toString();
        }
    }
}