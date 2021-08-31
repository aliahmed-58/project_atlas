package com.honda.atlas.controllers.admin;

import com.honda.atlas.service.admin.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/admin/home")
    public ModelAndView getHome() {
        return homeService.getHome();
    }

}
