package com.heights.auditapp.controller.impl;

import com.heights.auditapp.dto.AuditScopeDTO;
import com.heights.auditapp.dto.AuditUserDTO;
import com.heights.auditapp.mapper.AuditScopeMapper;
import com.heights.auditapp.mapper.AuditUniverseMapper;
import com.heights.auditapp.model.Approval_Status;
import com.heights.auditapp.model.AuditUniverse;
import com.heights.auditapp.service.AuditFocusProceduresService;
import com.heights.auditapp.service.AuditScopeService;
import com.heights.auditapp.service.AuditUniverseService;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class HomeController {

    private static final String UNIVERSE = "universe";
    private final AuditFocusProceduresService auditFocusProceduresService;
    private final AuditScopeService auditScopeService;
    private final AuditUniverseService auditUniverseService;
    private final AuditUniverseMapper auditUniverseMapper;
    private final AuditScopeMapper auditScopeMapper;
    
    public HomeController(AuditScopeMapper auditScopeMapper, AuditFocusProceduresService auditFocusProceduresService, AuditScopeService auditScopeService, AuditUniverseService auditUniverseService, AuditUniverseMapper auditUniverseMapper) {
        this.auditScopeMapper = auditScopeMapper;
        this.auditFocusProceduresService = auditFocusProceduresService;
        this.auditScopeService = auditScopeService;
        this.auditUniverseService = auditUniverseService;
        this.auditUniverseMapper = auditUniverseMapper;
    }

    @GetMapping("/dashboard")
    public String home(final Model model, HttpServletRequest req, @Nullable @RequestParam("email") String email) {

        AtomicInteger ongoing = new AtomicInteger(0);
        AtomicInteger scheduled = new AtomicInteger(0);
        AtomicInteger completed = new AtomicInteger(0);
        Object universe = req.getSession().getAttribute(UNIVERSE);
        List<AuditScopeDTO> foci = new ArrayList<>();
        List<AuditScopeDTO> approvalScope = new ArrayList<>();
        long approvals = 0;

        if(universe != null){
            long universeId = Long.parseLong(universe.toString());
            List<AuditScopeDTO> foc = auditScopeMapper.asDTOList(auditScopeService.findScopeByUniverseId(universeId));
            foc = auditScopeService.getScopeProgressLevel(foc);

            foc.forEach(x -> {
                if (Approval_Status.ACTIVE.equals(x.getApprovalStatus())){
                    ongoing.getAndIncrement();
                    if(foci.size() < 5)
                        foci.add(x);
                }
                else if( approvalScope.size() < 5 && Approval_Status.AWAITING_APPROVAL.equals(x.getApprovalStatus()))
                    approvalScope.add(x);
                else if (Approval_Status.SCHEDULED.equals(x.getApprovalStatus()))
                    scheduled.getAndIncrement();
                else
                    completed.getAndIncrement();

            });
            approvals = auditScopeService.countByUsernameAndApprovalStatus(email, universeId);
        }
        model.addAttribute("ongoing", ongoing);
        model.addAttribute("completed", completed);
        model.addAttribute("scheduled", scheduled);
        model.addAttribute("approvals", approvals);
        model.addAttribute("foci", foci);
        model.addAttribute("approvalScope", approvalScope);
        model.addAttribute(UNIVERSE, auditUniverseMapper.asDTOList(auditUniverseService.findAll()));
        return "dashboard";
    }

    @GetMapping({"", "/"})
    public String index(final Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.invalidate();

        model.addAttribute("user", new AuditUserDTO());
        return "login";
    }

    @PostMapping({"", "/"})
    public String login(@ModelAttribute("user") AuditUserDTO userDTO, final Model model) {
        model.addAttribute("user", new AuditUserDTO());
        return "login";
    }

    @GetMapping("/report")
    public String report(final Model model,
                         HttpServletRequest req) {
        return "report";
    }

    @GetMapping("/exception")
    public String exception(final Model model,
                            HttpServletRequest req) {
        String u = req.getSession().getAttribute(UNIVERSE).toString();
        if(u == null){
            return "redirect:/dashboard";
        }
        long universeId = Long.parseLong(u);
        Optional<AuditUniverse> univ = auditUniverseService.findById(universeId);
        String name = "";
        if(univ.isPresent()){
            name = univ.get().getUniverseName();
        }
        String finalName = name;
        model.addAttribute("proc", auditFocusProceduresService.getExceptions().stream().filter(x -> finalName.equals(x.getUniverse())));
        return "exception";
    }

    @GetMapping("/session/{universeId}")
    public @ResponseBody
    boolean setSession(HttpServletRequest req, @PathVariable Long universeId) {
        Optional<AuditUniverse> universe = auditUniverseService.findById(universeId);
        if (universe.isPresent()) {
            req.getSession().setAttribute(UNIVERSE, universe.get().getUniverseId());
            req.getSession().setAttribute("universeName", universe.get().getUniverseName());
            return true;
        }
        return false;
    }
}
