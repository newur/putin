package com.putin.user;

import com.putin.calendarservice.CalendarSetting;
import com.putin.calendarservice.googlecalendar.GoogleCalendarAuthorization;
import com.putin.calendarservice.googlecalendar.GoogleCalendarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserSettingsController {

    @RequestMapping("/authorize")
    public String handleReturnCode(@RequestParam("code") String code){
        try {
            GoogleCalendarAuthorization.authorize(code, "http://localhost:8080/authorize");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/usersettings";
    }

    @RequestMapping("/usersettings")
    public String usersettings(Model model) {
        UserSettings userSettings = UserSettingsMapper.getUserSettings();
        if(userSettings == null) {
            model.addAttribute("usersettings", new UserSettings());
            return "createUser";
        }
        else {
            if(GoogleCalendarAuthorization.checkAuthorization(userSettings.getUsername()) != null){
                updateCalendarSettings();
                model.addAttribute("usersettings", UserSettingsMapper.getUserSettings());
                return "userSettings";
            }
            else
                return "redirect:"+GoogleCalendarAuthorization.getGoogleLoginUri(userSettings.getUsername(),"http://localhost:8080/authorize");
        }
    }

    @RequestMapping("/saveusersettings")
    public String saveusersettings(UserSettings userSettings, final BindingResult bindingResult, final ModelMap model){
        if (bindingResult.hasErrors()) {
            return "userSettings";
        }
        UserSettingsMapper.setUserSettings(userSettings);
        model.clear();
        return "redirect:/usersettings";
    }

    private void updateCalendarSettings() {
        List<CalendarSetting> calendarsSettings = GoogleCalendarService.getCalendarSettings();
        UserSettings userSettings = UserSettingsMapper.getUserSettings();
        userSettings.setCalendarSettings(calendarsSettings);
        UserSettingsMapper.setUserSettings(userSettings);
    }


}
