package com.putin.calendar.model;

import java.util.ArrayList;
import java.util.List;

public class CalendarSettings {

    public CalendarSettings(){
        //TODO
    }

    private String calendarType;
    private List<Calendar> calendars = new ArrayList<>();
    private int maxDays;

    public String getCalendarType() {
        return calendarType;
    }

    public void setCalendarType(String calendarType) {
        this.calendarType = calendarType;
    }

    public List<Calendar> getCalendars() {
        return calendars;
    }

    public void setCalendars(List<Calendar> calendars) {
        this.calendars = calendars;
    }

    public int getMaxDays() {
        return maxDays;
    }

    public void setMaxDays(int maxDays) {
        this.maxDays = maxDays;
    }
}
