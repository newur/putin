package com.putin.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserSettingsController {

    @RequestMapping("/usersettings")
    public String usersettings(Model model) {
        model.addAttribute("username", UserSettingsMapper.getUserSettings().getUsername());
        return "userSettings";
    }

}
