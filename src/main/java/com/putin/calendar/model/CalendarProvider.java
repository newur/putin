package com.putin.calendar.model;


public enum CalendarProvider {

    GOOGLE("google"),
    ICALENDAR("icalendar");

    private String name;

    CalendarProvider(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
