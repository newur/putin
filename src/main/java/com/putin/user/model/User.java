package com.putin.user.model;

import com.putin.calendar.model.CalendarSettings;
import com.putin.clock.model.ClockSettings;
import com.putin.photos.model.PhotoSettings;
import lombok.Data;

import javax.persistence.*;
//import com.putin.rss.model.RssSettings;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

//    public User(String username, String password, String email) {
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.photoSettings = new PhotoSettings();
////        this.calendarSettings = new CalendarSettings();
////        this.rssSettings = new RssSettings();
//        this.clockSettings = new ClockSettings();
//    }

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
    //    private RssSettings rssSettings;

    public CalendarSettings getCalendarSettings() {
        return null;
    }

    public ClockSettings getClockSettings() {
        return null;
    }

    public PhotoSettings getPhotoSettings() {
        return null;
    }
}