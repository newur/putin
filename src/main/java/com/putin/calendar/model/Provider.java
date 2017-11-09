package com.putin.calendar.model;


public enum Provider {

    GOOGLE("google"),
    ICALENDAR("icalendar");

    private String name;

    Provider(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
