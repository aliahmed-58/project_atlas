package com.honda.atlas.service.admin;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

@Service
public class AdditionalSettingsService {

    public ModelAndView showAdditionalSettings() {
        return new ModelAndView("admin/additionalSettings");
    }

    @Transactional
    public void processForm() {

    }
}
