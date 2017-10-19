package com.putin.calendar.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CalendarDay {

    private Date day;
    private List<CalendarEvent> calendarEvents;

    public CalendarDay() {
    }

    public CalendarDay(Date day) {
        this.day = day;
    }

    public CalendarDay(Date day, List<CalendarEvent> calendarEvents) {
        this.day = day;
        this.calendarEvents = calendarEvents;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public List<CalendarEvent> getCalendarEvents() {
        return calendarEvents;
    }

    public void setCalendarEvents(List<CalendarEvent> calendarEvents) {
        this.calendarEvents = calendarEvents;
    }

    public String getDayAsString(){
        return new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN).format(day);
    }

    public String getDayRepresentation(){
        return new SimpleDateFormat("dd EE", Locale.GERMAN).format(day);
    }
}
