package com.putin.calendar;

import com.putin.calendar.services.google.GoogleCalendarService;
import com.putin.calendar.model.CalendarEvent;
import com.putin.calendar.util.CalendarEventSorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CalendarService {

    private final GoogleCalendarService googleCalendarService;

    @Autowired
    public CalendarService(GoogleCalendarService googleCalendarService) {
        this.googleCalendarService = googleCalendarService;
    }

    @RequestMapping("/calendarEvents")
    public List<CalendarEvent> getAllCalendarEvents(){
        List<CalendarEvent> calendarEvents = new ArrayList<>();
        calendarEvents.addAll(googleCalendarService.getCalendarEvents());
        return CalendarEventSorter.sortByStart(calendarEvents).subList(0,15);
    }

}
