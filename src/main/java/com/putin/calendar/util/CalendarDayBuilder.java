package com.putin.calendar.util;

import com.putin.calendar.model.CalendarDay;
import com.putin.calendar.model.CalendarDayEvent;
import com.putin.calendar.model.CalendarDayEventType;
import com.putin.calendar.model.CalendarEvent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CalendarDayBuilder {

    public static List<CalendarDay> getCalendarDays(List<CalendarEvent> calendarEvents){
        List<CalendarDay> calendarDays = new ArrayList<>();
        for(CalendarEvent calendarEvent : calendarEvents){
            calendarDays = updateCalendarDaysForEvent(calendarEvent, calendarDays);
        }
        return calendarDays;
    }

    private static List<CalendarDay> updateCalendarDaysForEvent(CalendarEvent calendarEvent, List<CalendarDay> calendarDays){
        if(calendarEvent.isAllday()){
            calendarDays = addEventToDay(calendarEvent.getStart().toLocalDate(), calendarEvent,
                    calendarDays, CalendarDayEventType.ALLDAY);
        }
        else if (calendarEvent.isMultiday()) {
            calendarDays = addEventToDay(calendarEvent.getStart().toLocalDate(), calendarEvent,
                    calendarDays, CalendarDayEventType.START);
            calendarDays = addEventToDay(calendarEvent.getEnd().toLocalDate(), calendarEvent,
                    calendarDays, CalendarDayEventType.END);
            for(LocalDate day : calendarEvent.getMiddleDays())
                calendarDays = addEventToDay(day, calendarEvent,
                        calendarDays, CalendarDayEventType.MIDDLE);
        }
        else{
            calendarDays = addEventToDay(calendarEvent.getStart().toLocalDate(), calendarEvent,
                    calendarDays, CalendarDayEventType.NORMAL);
        }
        return calendarDays;
    }

    private static List<CalendarDay> addEventToDay(LocalDate day, CalendarEvent calendarEvent,
                                                   List<CalendarDay> calendarDays, CalendarDayEventType type){
        boolean dayExists=false;
        for(CalendarDay calendarDay : calendarDays){
            if(calendarDay.getDay().equals(day)) {
                dayExists=true;
                calendarDay.getAssignedCalendarEvents().add(new CalendarDayEvent(calendarDay,type,calendarEvent));
            }
        }
        if(!dayExists){
            CalendarDay calendarDay = new CalendarDay(day);
            calendarDay.getAssignedCalendarEvents().add(new CalendarDayEvent(calendarDay,type,calendarEvent));
            calendarDays.add(calendarDay);
        }
        return calendarDays;
    }

}
