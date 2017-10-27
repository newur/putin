package com.putin.calendar;

import com.putin.calendar.model.CalendarDay;
import com.putin.calendar.services.google.GoogleCalendarService;
import com.putin.calendar.model.CalendarEvent;
import com.putin.calendar.util.CalendarDayBuilder;
import com.putin.calendar.util.CalendarEventAdapter;
import com.putin.user.UserSettingsProvider;
import com.putin.user.model.CalendarSetting;
import com.putin.user.model.UserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.*;

@RestController
class CalendarService {

    private final GoogleCalendarService googleCalendarService;
    private final UserSettingsProvider userSettingsProvider;

    @Autowired
    public CalendarService(GoogleCalendarService googleCalendarService, UserSettingsProvider userSettingsProvider) {
        this.googleCalendarService = googleCalendarService;
        this.userSettingsProvider = userSettingsProvider;
    }

    @RequestMapping("/calendarEvents")
    public List<CalendarEvent> getAllCalendarEvents(){
        UserSettings userSettings = userSettingsProvider.getUserSettings();
        List<CalendarEvent> calendarEvents = new ArrayList<>();
        for(CalendarSetting calendarSetting : userSettings.getCalendarSettings()){
            if(calendarSetting.isSelected()) {
                calendarEvents.addAll(CalendarEventAdapter.addCalenderSettingsToEvent(
                        googleCalendarService.getCalendarEvents(userSettings.getUsername(),calendarSetting.getId()),
                        calendarSetting));
            }
        }
        return calendarEvents.stream()
                .sorted(Comparator.comparing(CalendarEvent::getStart))
                .collect(toList());
    }

    @RequestMapping("/calendarDays")
    public List<CalendarDay> getCalendarDays(){
        UserSettings userSettings = userSettingsProvider.getUserSettings();
        List<CalendarEvent> calendarEvents = new ArrayList<>();
        for(CalendarSetting calendarSetting : userSettings.getCalendarSettings()){
            if(calendarSetting.isSelected()) {
                calendarEvents.addAll(CalendarEventAdapter.addCalenderSettingsToEvent(
                        googleCalendarService.getCalendarEvents(userSettings.getUsername(),calendarSetting.getId()),
                        calendarSetting));
            }
        }
        return CalendarDayBuilder.getCalendarDays(calendarEvents)
                .stream()
                .sorted(Comparator.comparing(CalendarDay::getDay))
                .collect(toList()).subList(0,20);
    }

}
