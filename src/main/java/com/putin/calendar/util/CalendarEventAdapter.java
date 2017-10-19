package com.putin.calendar.util;

import com.putin.calendar.model.CalendarEvent;
import com.putin.user.model.CalendarSetting;

import java.util.List;

public class CalendarEventAdapter {

    public static List<CalendarEvent> addCalenderSettingsToEvent(List<CalendarEvent> calendarEvents, CalendarSetting calendarSetting){
        for(CalendarEvent calendarEvent : calendarEvents){
            calendarEvent.setColor(calendarSetting.getColor());
        }
        return calendarEvents;
    }

}
