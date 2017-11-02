package com.putin.user.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;

    //Time
    private String clockType;

    //Calendar
    private String calendarType;
    private List<CalendarSetting> calendarSettings = new ArrayList<>();

    //Photos
    private int pictureTime;

    // RSS
    private String rssUrl;
    private int rssTime;

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

    public String getRssUrl() {
        return rssUrl;
    }

    public void setRssUrl(String rssUrl) {
        this.rssUrl = rssUrl;
    }

    public int getRssTime() {
        return rssTime;
    }

    public void setRssTime(int rssTime) {
        this.rssTime = rssTime;
    }
}