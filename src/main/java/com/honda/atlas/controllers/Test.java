package com.honda.atlas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test {

    @GetMapping("/")
    public ModelAndView getHome() {
        return new ModelAndView("home");
    }
}
