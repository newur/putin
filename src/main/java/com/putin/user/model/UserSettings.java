package com.putin.user.model;

import java.util.ArrayList;
import java.util.List;

public class UserSettings {

    private String username;
    private List<CalendarSetting> calendarSettings = new ArrayList<>();
    private String clockType;

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
}