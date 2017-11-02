package com.putin.calendar;

import com.putin.calendar.model.CalendarDay;
import com.putin.calendar.services.google.GCalendarService;
import com.putin.calendar.model.CalendarEvent;
import com.putin.calendar.util.CalendarDayBuilder;
import com.putin.calendar.util.CalendarEventAdapter;
import com.putin.user.UserProvider;
import com.putin.user.model.CalendarSetting;
import com.putin.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.*;

@RestController
class CalendarService {

    private final GCalendarService gCalendarService;
    private final UserProvider userProvider;

    @Autowired
    public CalendarService(GCalendarService gCalendarService, UserProvider userProvider) {
        this.gCalendarService = gCalendarService;
        this.userProvider = userProvider;
    }

    @RequestMapping("/calendarEvents")
    public List<CalendarEvent> getAllCalendarEvents(){
        User user = userProvider.getUserSettings();
        List<CalendarEvent> calendarEvents = new ArrayList<>();
        for(CalendarSetting calendarSetting : user.getCalendarSettings()){
            if(calendarSetting.isSelected()) {
                calendarEvents.addAll(CalendarEventAdapter.addCalenderSettingsToEvent(
                        gCalendarService.getCalendarEvents(user.getUsername(),calendarSetting.getId()),
                        calendarSetting));
            }
        }
        return calendarEvents.stream()
                .sorted(Comparator.comparing(CalendarEvent::getStart))
                .collect(toList());
    }

    @RequestMapping("/calendarDays")
    public List<CalendarDay> getCalendarDays(){
        User user = userProvider.getUserSettings();
        List<CalendarEvent> calendarEvents = new ArrayList<>();
        for(CalendarSetting calendarSetting : user.getCalendarSettings()){
            if(calendarSetting.isSelected()) {
                calendarEvents.addAll(CalendarEventAdapter.addCalenderSettingsToEvent(
                        gCalendarService.getCalendarEvents(user.getUsername(),calendarSetting.getId()),
                        calendarSetting));
            }
        }
        return CalendarDayBuilder.getCalendarDays(calendarEvents)
                .stream()
                .sorted(Comparator.comparing(CalendarDay::getDay))
                .collect(toList()).subList(0,10);
    }

}
