package com.putin.user;

import com.google.api.services.calendar.model.CalendarListEntry;
import com.putin.calendarservice.CalendarSetting;
import com.putin.calendarservice.CalendarWebService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserSettingsController {

    public void updateCalendarSettings() {
        List<CalendarSetting> calendarsSettings = new ArrayList<CalendarSetting>();

        CalendarWebService calendarWebService = new CalendarWebService();
        List<CalendarListEntry> calendars = new ArrayList<CalendarListEntry>();
        try {
            calendars = (List<CalendarListEntry>) calendarWebService.getCalendars("johanneshartig@gmail.com").getEntity();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(CalendarListEntry entry: calendars){
            calendarsSettings.add(
                    new CalendarSetting("google", entry.getId(), entry.getSummary(),
                            entry.getDescription(), checkCalendarSelection(entry.getId()) ));
        }
        UserSettings userSettings = UserSettingsMapper.getUserSettings();
        userSettings.setCalendarSettings(calendarsSettings);
        UserSettingsMapper.setUserSettings(userSettings);
    }

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

    public boolean checkCalendarSelection(String id){
        for(CalendarSetting calendarSetting : UserSettingsMapper.getUserSettings().getCalendarSettings()){
            if(calendarSetting.getId().equals(id) && calendarSetting.isSelected())
                return true;
        }
        return false;
    }

}
