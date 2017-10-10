package com.putin.calendarservice;

import java.util.Date;

public class CalendarEvent {

    private String name;
    private String description;
    private String location;
    private Date start;
    private Date end;

    public CalendarEvent() {
    }

    public CalendarEvent(String name, String description, String location, Date start, Date end) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.start = start;
        this.end = end;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
