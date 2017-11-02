package com.putin.user.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;
    private List<CalendarSetting> calendarSettings = new ArrayList<>();
    private String clockType;
    private String calendarType;
    private int pictureTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<CalendarSetting> getCalendarSettings() {
        return calendarSettings;
    }

    public void setCalendarSettings(List<CalendarSetting> calendarSettings) {
        this.calendarSettings = calendarSettings;
    }

    public String getClockType() {
        return clockType;
    }

    public void setClockType(String clockType) {
        this.clockType = clockType;
    }

    public String getCalendarType() {
        return calendarType;
    }

    public void setCalendarType(String calendarType) {
        this.calendarType = calendarType;
    }

    public int getPictureTime() {
        return pictureTime;
    }

    public void setPictureTime(int pictureTime) {
        this.pictureTime = pictureTime;
    }

}