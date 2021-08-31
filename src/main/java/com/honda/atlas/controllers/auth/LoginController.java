package com.honda.atlas.controllers.auth;

import com.honda.atlas.models.Users;
import com.honda.atlas.service.auth.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public ModelAndView showLogin(Authentication auth) {
        return loginService.showLoginForm(auth);
    }

    @PostMapping("/login")
    public void processLogin(@ModelAttribute Users user) {
//        return authService.processLogin();
    }

    @GetMapping("/login-error")
    public ModelAndView loginError(HttpServletRequest req, org.springframework.security.core.Authentication auth) {

        return loginService.loginError(req, auth);

    }

}
