package com.honda.atlas.service.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class LoginService {

    public ModelAndView showLoginForm(Authentication auth) {
        if (auth != null)
            return new ModelAndView("redirect:admin/home");
        else
            return new ModelAndView("login");
    }

    public ModelAndView processLogin() {
        return new ModelAndView("home");
    }

    public ModelAndView loginError(HttpServletRequest req, Authentication auth) {
        // user already authenticated
        if (auth != null)
            return new ModelAndView("redirect:/admin/home");

        HttpSession session = req.getSession();
        String errMessage = null;
        if (session != null) {
            AuthenticationException ex = (AuthenticationException) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

            if (ex != null) {
                errMessage = ex.getMessage();
            }
        }

        ModelAndView mv = new ModelAndView("login");
        mv.addObject("error", errMessage);
        return mv;
    }


}
