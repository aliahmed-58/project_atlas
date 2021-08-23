package com.honda.atlas.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class AuthService {

    public ModelAndView showLoginForm() {
        return new ModelAndView("login");
    }

    public ModelAndView processLogin() {
        return new ModelAndView("home");
    }
}
