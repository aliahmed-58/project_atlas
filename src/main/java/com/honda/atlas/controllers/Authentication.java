package com.honda.atlas.controllers;

import com.honda.atlas.models.Users;
import com.honda.atlas.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Authentication {

    private final AuthService authService;

    @Autowired
    public Authentication(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public ModelAndView showLogin() {
        return authService.showLoginForm();
    }

    @PostMapping("/login")
    public void processLogin(@ModelAttribute Users user) {
//        return authService.processLogin();
    }

    @GetMapping("/login-error")
    public ModelAndView loginError(HttpServletRequest req, org.springframework.security.core.Authentication auth) {

        if (auth != null) {
            return  new ModelAndView("redirect:/home");
        }

        HttpSession session = req.getSession();
        String errorMessage = null;
        if (session != null) {
            AuthenticationException ex = (AuthenticationException) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

            if (ex != null) {
                errorMessage = ex.getMessage();
            }
        }
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("error", errorMessage);
        return mv;

    }

}
