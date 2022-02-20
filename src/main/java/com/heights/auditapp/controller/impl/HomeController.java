package com.heights.auditapp.controller.impl;

import com.heights.auditapp.dto.AuditUserDTO;
import com.heights.auditapp.mapper.AuditUniverseMapper;
import com.heights.auditapp.model.Approval_Status;
import com.heights.auditapp.model.AuditFocus;
import com.heights.auditapp.service.AuditFocusProceduresService;
import com.heights.auditapp.service.AuditFocusService;
import com.heights.auditapp.service.AuditScopeService;
import com.heights.auditapp.service.AuditUniverseService;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final AuditFocusService auditFocusService;
    private final AuditFocusProceduresService auditFocusProceduresService;
    private final AuditScopeService auditScopeService;
    private final AuditUniverseService auditUniverseService;
    private final AuditUniverseMapper auditUniverseMapper;

    public HomeController(AuditFocusService auditFocusService, AuditFocusProceduresService auditFocusProceduresService, AuditScopeService auditScopeService, AuditUniverseService auditUniverseService, AuditUniverseMapper auditUniverseMapper) {
        this.auditFocusService = auditFocusService;
        this.auditFocusProceduresService = auditFocusProceduresService;
        this.auditScopeService = auditScopeService;
        this.auditUniverseService = auditUniverseService;
        this.auditUniverseMapper = auditUniverseMapper;
    }

    @GetMapping("/dashboard")
    public String home(final Model model,
                       HttpServletRequest req, @Nullable @RequestParam("email") String email) {

        List<AuditFocus> foc = auditFocusService.findAll();
        AtomicInteger ongoing = new AtomicInteger();
        AtomicInteger scheduled = new AtomicInteger();
        AtomicInteger completed = new AtomicInteger();

        foc.forEach(x -> {
            if(Approval_Status.ACTIVE.name().equals(x.getApprovalStatus()))
                ongoing.getAndIncrement();
            else if(Approval_Status.SCHEDULED.name().equals(x.getApprovalStatus()))
                scheduled.getAndIncrement();
            else
                completed.getAndIncrement();
        });

        model.addAttribute("dashboard", "");
        model.addAttribute("foci", foc
                .stream()
                .filter(x -> "S".equals(x.getStartFlag()))
                .collect(Collectors.toList()) );
        model.addAttribute("ongoing", ongoing);
        model.addAttribute("completed", completed);
        model.addAttribute("scheduled", scheduled);
        model.addAttribute("approvalScope",
                auditScopeService
                        .findAll()
                        .stream()
                        .filter(x -> Approval_Status.AWAITING_APPROVAL.name().equals(x.getApprovalStatus()))
                        .collect(Collectors.toList()));
        model.addAttribute("approvals", auditScopeService.countByUsernameAndApprovalStatus(email));
        model.addAttribute("universe", auditUniverseMapper.asDTOList(auditUniverseService.findAll()));
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
        model.addAttribute("proc",auditFocusProceduresService.getExceptions());
        return "exception";
    }
}
