package com.honda.atlas.controllers.admin;

import com.honda.atlas.service.admin.AdditionalSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdditionalSettings {

    private final AdditionalSettingsService additionalSettingsService;

    @Autowired
    public AdditionalSettings(AdditionalSettingsService additionalSettingsService) {
        this.additionalSettingsService = additionalSettingsService;
    }

    @GetMapping("/admin/additionalSettings")
    public ModelAndView showSettings() {
        return this.additionalSettingsService.showAdditionalSettings();
    }


}
