package com.heights.auditapp.controller.impl;

import com.heights.auditapp.dto.AuditUserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @GetMapping("/dashboard")
    public String home(@ModelAttribute("auditUser") final AuditUserDTO userProfile, final Model model,
                       HttpServletRequest req) {
        String username = (String) req.getSession().getAttribute("username");
        model.addAttribute("userProfile", userProfile);
        model.addAttribute("dashboard", "");

        return "dashboard";
    }

    @GetMapping({"", "/"})
    public String login(final Model model) {
        model.addAttribute("user", new AuditUserDTO());
        return "login";
    }
}
