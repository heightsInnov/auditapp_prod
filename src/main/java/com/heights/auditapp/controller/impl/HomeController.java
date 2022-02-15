package com.heights.auditapp.controller.impl;

import com.heights.auditapp.dto.AuditUserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/dashboard")
    public String home(final Model model,
                       HttpServletRequest req) {
        model.addAttribute("dashboard", "");
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
}
