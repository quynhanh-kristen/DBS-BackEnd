package com.rade.dentistbookingsystem.controller;


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
@RequestMapping("login")
public class AccountLoginController {
    private final String HOME_PAGE = "guest/home";
    private final String USER_PAGE = "guest/home";
    private final String ADMIN_PAGE = "admin/admin";
    private final String ADMIN_ROLE = "ADMIN";
    private final String USER_ROLE = "USER";
    private final String ERROR = "error";

    @RequestMapping()
    public String login(SecurityContextHolder auth) {
        Collection<? extends GrantedAuthority> granted = auth.getContext().getAuthentication().getAuthorities();
        // LẤy role của user đã đăng nhập

        String role = granted.toArray()[0].toString();
        if (ADMIN_ROLE.equals(role)) {
            return viewAdminPage();
        } else if (USER_ROLE.equals(role)) {
            return USER_PAGE;

        } else {
            return "guest/home";
        }

    }

    @GetMapping("admin/admin")
    public String viewAdminPage() {
        return ADMIN_PAGE;
    }


    @GetMapping("/login-error")
    public String login(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        String errorMessage = null;
        if (session != null) {
            AuthenticationException ex = (AuthenticationException) session
                    .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (ex != null) {
                errorMessage = ex.getMessage();
            }
        }
        model.addAttribute("errorMessage", errorMessage);
        return HOME_PAGE;
    }


}
