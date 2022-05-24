package com.rade.dentistbookingsystem.controller;


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
@RequestMapping("login")
public class AccountLoginController {

    private final String USER_PAGE = "home";
    private final String ADMIN_PAGE = "admin/admin";
    private final String ADMIN_ROLE = "ADMIN";
    private final String USER_ROLE = "USER";
    private final String ERROR = "error";



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
        return "home";
    }


    @PostMapping("/authen-user")
    public String authenUser(SecurityContextHolder auth) {
        String url = ERROR;
        Collection<? extends GrantedAuthority> granted = auth.getContext().getAuthentication().getAuthorities();
        // LẤy role của user đã đăng nhập
        String role = granted.toArray()[0].toString();
        if (ADMIN_ROLE.equals(role)) {
            url = ADMIN_PAGE;
        } else if (USER_ROLE.equals(role)) {
            url = USER_PAGE;

        }
        return  url;
    }


}
