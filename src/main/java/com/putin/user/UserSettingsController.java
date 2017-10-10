package com.putin.user;

import com.putin.calendarservice.CalendarSetting;
import com.putin.calendarservice.googlecalendar.GoogleCalendarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserSettingsController {

    @RequestMapping("/usersettings")
    public String usersettings(Model model) {
        updateCalendarSettings();
        model.addAttribute("usersettings", UserSettingsMapper.getUserSettings());
        return "userSettings";
    }

    @RequestMapping("/saveusersettings")
    public String saveusersettings(UserSettings userSettings, final BindingResult bindingResult, final ModelMap model){
        if (bindingResult.hasErrors()) {
            return "userSettings";
        }
        UserSettingsMapper.setUserSettings(userSettings);
        model.clear();
        return "redirect:/userSettings";
    }

    private void updateCalendarSettings() {
        List<CalendarSetting> calendarsSettings = GoogleCalendarService.getCalendarSettings();
        UserSettings userSettings = UserSettingsMapper.getUserSettings();
        userSettings.setCalendarSettings(calendarsSettings);
        UserSettingsMapper.setUserSettings(userSettings);
    }


}
