package com.putin.calendarservice;

import com.putin.calendarservice.googlecalendar.GoogleCalendarService;
import com.putin.user.UserSettings;
import com.putin.user.UserSettingsMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CalendarController {

        @RequestMapping("/calendar")
        public String calendar(Model model) {
            UserSettings userSettings = UserSettingsMapper.getUserSettings();
            if(userSettings == null) {
                model.addAttribute("usersettings", new UserSettings());
                return "createUser";
            }
            model.addAttribute("calendarevents", getAllCalendarEvents());
            return "calendar";
        }

        private static List<CalendarEvent> getAllCalendarEvents(){
            List<CalendarEvent> calendarEvents = new ArrayList<>();
            calendarEvents.addAll(GoogleCalendarService.getCalendarEvents());
            return calendarEvents;
        }

}
