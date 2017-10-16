package com.putin.calendar.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CalendarEvent {

    private String name;
    private String description;
    private String location;
    private Date start;
    private Date end;
    private boolean allday;

    private final DateFormat df2 = new SimpleDateFormat("HH:mm", Locale.GERMAN);

    public CalendarEvent() {
    }

    public CalendarEvent(String name, String description, String location, Date start, Date end, boolean allday) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.start = start;
        this.end = end;
        this.allday = allday;
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

    public boolean isAllday() {
        return allday;
    }

    public void setAllday(boolean allday) {
        this.allday = allday;
    }

    public String getStartAsString(){
        if(start!=null && !allday)
            return df2.format(start);
        else return "";
    }

    public String getEndAsString(){
        if(end!=null && !allday)
            return df2.format(end);
        else return "";
    }

}
