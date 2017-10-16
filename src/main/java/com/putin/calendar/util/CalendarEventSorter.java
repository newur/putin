package com.putin.calendar.util;

import com.putin.calendar.model.CalendarEvent;

import java.util.Collections;
import java.util.List;

public class CalendarEventSorter {

    public static List<CalendarEvent> sortByStart(List<CalendarEvent> calendarEvents){
        Collections.sort(calendarEvents, (o1, o2) -> {
            if (o1.getStart() == null || o2.getStart() == null)
                return 0;
            return o1.getStart().compareTo(o2.getStart());
        });
        return calendarEvents;
    }

}
