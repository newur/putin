package com.putin.calendar.util;

import com.putin.calendar.model.CalendarEvent;
import com.putin.calendar.model.Calendar;

import java.util.List;

public class CalendarEventAdapter {

    public static List<CalendarEvent> addCalenderSettingsToEvent(List<CalendarEvent> calendarEvents, Calendar calendar){
        for(CalendarEvent calendarEvent : calendarEvents){
            calendarEvent.setColor(calendar.getColor());
        }
        return calendarEvents;
    }

}
