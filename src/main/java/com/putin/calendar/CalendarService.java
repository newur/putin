package com.putin.calendar;

import com.putin.calendar.services.google.GoogleCalendarService;
import com.putin.calendar.model.CalendarEvent;
import com.putin.calendar.util.CalendarEventSorter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CalendarService {

        @RequestMapping("/calendarEvents")
        private static List<CalendarEvent> getAllCalendarEvents(){
            List<CalendarEvent> calendarEvents = new ArrayList<>();
            calendarEvents.addAll(GoogleCalendarService.getCalendarEvents());
            return CalendarEventSorter.sortByStart(calendarEvents).subList(0,15);
        }

}
