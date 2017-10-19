package com.putin.calendar.util;

import com.putin.calendar.model.CalendarDay;
import com.putin.calendar.model.CalendarEvent;

import java.util.ArrayList;
import java.util.List;

public class CalendarDayCreator {

    public static List<CalendarDay> getCalendarDays(List<CalendarEvent> calendarEvents){
        List<CalendarDay> calendarDays = new ArrayList<>();
        for(CalendarEvent calendarEvent : calendarEvents){
            calendarDays = updateCalendarDaysForEvent(calendarEvent, calendarDays);
        }
        return calendarDays;
    }

    public static List<CalendarDay> updateCalendarDaysForEvent(CalendarEvent calendarEvent,List<CalendarDay> calendarDays){
        if(calendarEvent.isAllday()){
            boolean dayExists = false;
            for(CalendarDay calendarDay : calendarDays){
                if(calendarDay.getDayAsString().equals(calendarEvent.getStartDayAsString())) {
                    calendarDay.getCalendarEvents().add(calendarEvent);
                    dayExists = true;
                }
            }
            if(!dayExists)
                calendarDays.add(new CalendarDay(calendarEvent.getStart(),java.util.Arrays.asList(calendarEvent)));
        }
        return calendarDays;
    }

}
