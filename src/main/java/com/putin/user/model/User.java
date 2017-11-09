package com.putin.user.model;

import com.putin.calendar.model.CalendarSettings;
import com.putin.clock.model.ClockSettings;
import com.putin.photos.model.PhotoSettings;
import com.putin.rss.model.RssSettings;

public class User {

    public User(){
        //TODO
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.photoSettings = new PhotoSettings();
        this.calendarSettings = new CalendarSettings();
        this.rssSettings = new RssSettings();
        this.clockSettings = new ClockSettings();
    }

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String birthday;
    private String email;

    private PhotoSettings photoSettings;
    private CalendarSettings calendarSettings;
    private RssSettings rssSettings;
    private ClockSettings clockSettings;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PhotoSettings getPhotoSettings() {
        return photoSettings;
    }

    public void setPhotoSettings(PhotoSettings photoSettings) {
        this.photoSettings = photoSettings;
    }

    public CalendarSettings getCalendarSettings() {
        return calendarSettings;
    }

    public void setCalendarSettings(CalendarSettings calendarSettings) {
        this.calendarSettings = calendarSettings;
    }

    public RssSettings getRssSettings() {
        return rssSettings;
    }

    public void setRssSettings(RssSettings rssSettings) {
        this.rssSettings = rssSettings;
    }

    public ClockSettings getClockSettings() {
        return clockSettings;
    }

    public void setClockSettings(ClockSettings clockSettings) {
        this.clockSettings = clockSettings;
    }
}