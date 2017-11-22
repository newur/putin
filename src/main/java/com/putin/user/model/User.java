package com.putin.user.model;

import com.putin.authorization.services.google.GoogleCredentials;
import com.putin.calendar.model.CalendarSettings;
import com.putin.clock.model.ClockSettings;
import com.putin.photos.model.PhotoSettings;
import lombok.Data;

import javax.persistence.*;
import com.putin.rss.model.RssSettings;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

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
        this.googleCredentials = new GoogleCredentials();
    }

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String birthday;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private ClockSettings clockSettings;

    @OneToOne(cascade = CascadeType.ALL)
    private PhotoSettings photoSettings;

    @OneToOne(cascade = CascadeType.ALL)
    private CalendarSettings calendarSettings;

    @OneToOne(cascade = CascadeType.ALL)
    private RssSettings rssSettings;

    @OneToOne(cascade = CascadeType.ALL)
    private GoogleCredentials googleCredentials;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public ClockSettings getClockSettings() {
        return clockSettings;
    }

    public PhotoSettings getPhotoSettings() {
        return photoSettings;
    }

    public CalendarSettings getCalendarSettings() {
        return calendarSettings;
    }

    public RssSettings getRssSettings() {
        return rssSettings;
    }

    public GoogleCredentials getGoogleCredentials() {
        return googleCredentials;
    }

}