package com.putin.utils;

import com.putin.model.calendar.CalendarEvent;
import com.putin.model.calendar.Calendar;

import java.util.List;

public class CalendarEventAdapter {

    public static List<CalendarEvent> addCalenderSettingsToEvent(List<CalendarEvent> calendarEvents, Calendar calendar){
        for(CalendarEvent calendarEvent : calendarEvents){
            calendarEvent.setColor(calendar.getColor());
        }
        return calendarEvents;
    }

}
