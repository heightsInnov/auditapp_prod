package com.heights.auditapp.controller.impl;

import com.heights.auditapp.controller.AuditScopeApproavalController;
import com.heights.auditapp.dto.AuditFocusDTO;
import com.heights.auditapp.dto.AuditFocusProceduresDTO;
import com.heights.auditapp.dto.AuditScopeApproavalDTO;
import com.heights.auditapp.dto.AuditScopeDTO;
import com.heights.auditapp.mapper.AuditFocusMapper;
import com.heights.auditapp.mapper.AuditFocusProceduresMapper;
import com.heights.auditapp.mapper.AuditScopeMapper;
import com.heights.auditapp.model.AUDIT_TYPE;
import com.heights.auditapp.model.Approval_Status;
import com.heights.auditapp.model.AuditFocusProcedures;
import com.heights.auditapp.model.AuditScope;
import com.heights.auditapp.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequestMapping("/audit-scope")
@Controller
public class AuditScopeControllerImpl {
    private final AuditScopeService auditScopeService;
    private final AuditScopeMapper auditScopeMapper;
    private final AuditFocusProceduresMapper auditFocusProceduresMapper;
    private final AuditFocusMapper auditFocusMapper;
    private final AuditUniverseService auditUniverseService;
    private final AuditScopeApproavalController auditScopeApproaval;
    private final AuditUserService auditUserService;
    private final AuditFocusService auditFocusService;
    private final AuditFocusProceduresService auditFocusProceduresService;

    public AuditScopeControllerImpl(AuditScopeService auditScopeService, AuditScopeMapper auditScopeMapper,
                                    AuditFocusProceduresMapper auditFocusProceduresMapper, AuditFocusMapper auditFocusMapper, AuditUniverseService auditUniverseService, AuditScopeApproavalController auditScopeApproaval,
                                    AuditUserService auditUserService, AuditFocusService auditFocusService,
                                    AuditFocusProceduresService auditFocusProceduresService) {
        this.auditScopeService = auditScopeService;
        this.auditScopeMapper = auditScopeMapper;
        this.auditFocusProceduresMapper = auditFocusProceduresMapper;
        this.auditFocusMapper = auditFocusMapper;
        this.auditUniverseService = auditUniverseService;
        this.auditScopeApproaval = auditScopeApproaval;
        this.auditUserService = auditUserService;
        this.auditFocusService = auditFocusService;
        this.auditFocusProceduresService = auditFocusProceduresService;
    }

    @GetMapping
    public String load(Model model){
        model.addAttribute("universe", auditUniverseService.findAll());
        model.addAttribute("scope", new AuditScopeDTO());
        model.addAttribute("user", auditUserService.findAll());
        return "scope";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("universe", auditUniverseService.findAll());
        model.addAttribute("scope", new AuditScopeDTO());
        model.addAttribute("auditType", AUDIT_TYPE.values());
        model.addAttribute("user", auditUserService.findAll());
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
        return "redirect:/audit-scope/create";
    }

    @GetMapping("/{id}")
    public @ResponseBody AuditScopeDTO findById(@PathVariable("id") Long id) {
        return auditScopeMapper.asDTO(auditScopeService.findById(id).orElse(null));
    }

    @GetMapping("/find-by-entity/{id}")
    public @ResponseBody List<AuditScopeDTO> findByEntityId(@PathVariable("id") Long entityId) {
        List<AuditScopeDTO> scopes = auditScopeMapper.asDTOList(auditScopeService.findByEntityId(entityId));
        scopes = auditScopeService.getScopeProgressLevel(scopes);
        return scopes;
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

    @GetMapping("/preview/{scopeId}")
    public String viewScope(@NotNull @PathVariable long scopeId, Model model){
        if(scopeId < 0L){
            return "redirect:/audit-scope";
        }
        List<AuditFocusDTO> auditFocus = auditFocusMapper.asDTOList(auditFocusService.findAuditFocusByScope(scopeId));
        List<AuditFocusProceduresDTO> procedures = auditFocusProceduresMapper.asDTOList(auditFocusProceduresService.findAll());
        for (AuditFocusDTO focus : auditFocus) {
            long procCount = procedures.stream().filter(x -> x.getFocusId().equals(focus.getId())).count();
            if(procCount > 0) {
                long compCount = procedures.stream().filter(x -> x.getFocusId().equals(focus.getId()) && x.getStatus().equals(Approval_Status.COMPLETED)).count();
                Long cc = (compCount*100)/procCount;
                focus.setProgressLevel(compCount > 0 ? cc.intValue() : 0);
            }
        }
        model.addAttribute("focus", new AuditFocusDTO());
        model.addAttribute("scope", new AuditScopeDTO());
        auditScopeService.findById(scopeId).ifPresent(auditScope -> model.addAttribute("scoped", auditScopeMapper.asDTO(auditScope)));
        model.addAttribute("foci", auditFocus);
        model.addAttribute("procedures", procedures.stream().distinct().collect(Collectors.toList()));
        return "view-scope";
    }

    @GetMapping("/procedures/{focusId}")
    public @ResponseBody List<AuditFocusProcedures> proceduresBy(@PathVariable Long focusId) {
        return auditFocusProceduresService.findAll()
                .stream()
                .filter(x -> x.getFocusId().equals(focusId)).collect(Collectors.toList());
    }

    @GetMapping("/assign")
    public String assignAuditee(@ModelAttribute AuditScopeDTO auditScopeDTO){
        if(auditScopeDTO.getScopeId() < 0L){
            return "redirect:/audit-scope";
        }
        auditScopeService.updateScopeAuditor(auditScopeDTO.getScopeId(), auditScopeDTO.getUserName());
    return "redirect:/audit-scope";
    }

    @GetMapping("/execute")
    public String auditExecution(Model model, HttpServletRequest request) {
        Object universe = request.getSession().getAttribute("universe");
        if(universe == null)
        {
            return "redirect:/dashboard";
        }
        Long universeId = Long.parseLong(universe.toString());
        List<AuditScopeDTO> dtos = auditScopeMapper.asDTOList(auditScopeService.findScopeByUniverseId(universeId));
        dtos = auditScopeService.getScopeProgressLevel(dtos);
        model.addAttribute("universe", auditUniverseService.findAll());
        model.addAttribute("scope", dtos);
        return "execution-scope";
    }
}