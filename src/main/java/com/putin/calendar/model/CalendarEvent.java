package com.putin.calendar.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CalendarEvent {

    private String name;
    private String description;
    private String location;
    private String color;
    private Date start;
    private Date end;
    private boolean allday;

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStartAsString(){
        if(start!=null && !allday)
            return new SimpleDateFormat("HH:mm", Locale.GERMAN).format(start);
        else return "";
    }

    public String getStartDayAsString(){
        return new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN).format(start);
    }

    public String getEndAsString(){
        if(end!=null && !allday)
            return new SimpleDateFormat("HH:mm", Locale.GERMAN).format(end);
        else return "";
    }


}
