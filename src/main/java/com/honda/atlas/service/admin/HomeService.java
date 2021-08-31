package com.honda.atlas.service.admin;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class HomeService {

    public ModelAndView getHome() {
        return new ModelAndView("admin/home");
    }
}
