package com.putin.calendar;

import com.putin.calendar.services.google.GoogleCalendarService;
import com.putin.calendar.model.CalendarEvent;
import com.putin.calendar.util.CalendarEventSorter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
public class CalendarService {

        @RequestMapping("/calendarEvents")
        private static List<CalendarEvent> getAllCalendarEvents(){
            List<CalendarEvent> calendarEvents = new ArrayList<>();
            calendarEvents.addAll(GoogleCalendarService.getCalendarEvents());

            return calendarEvents.stream()
                    .sorted(Comparator.comparing(CalendarEvent::getStart))
                    .limit(15)
                    .collect(toList());
        }

}
