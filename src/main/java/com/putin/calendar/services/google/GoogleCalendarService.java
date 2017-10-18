package com.putin.calendar.services.google;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;
import com.putin.calendar.model.CalendarEvent;
import com.putin.user.UserSettingsProvider;
import com.putin.user.model.CalendarSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GoogleCalendarService {

    private final GoogleCalendarSettingFormatter formatter;
    private final UserSettingsProvider userSettingsProvider;

    @Autowired
    public GoogleCalendarService(GoogleCalendarSettingFormatter formatter, UserSettingsProvider userSettingsProvider) {
        this.formatter = formatter;
        this.userSettingsProvider = userSettingsProvider;
    }

    public static String checkAuthorization(){
        return "";
    }

    public List<CalendarEvent> getCalendarEvents(){
        List<Event> events = new ArrayList<>();
        for(CalendarSetting calendarSetting : userSettingsProvider.getUserSettings().getCalendarSettings()) {
            if(calendarSetting.isSelected()) {
                try {
                    com.google.api.services.calendar.Calendar service =
                            GoogleCalendarAuthorization.getCalendarService(userSettingsProvider.getUserSettings().getUsername());
                    events.addAll(service.events()
                            .list(calendarSetting.getId())
                            .setMaxResults(30)
                            .setTimeMin(new DateTime(new Date()))
                            .setOrderBy("startTime")
                            .setSingleEvents(true)
                            .execute()
                            .getItems());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return GoogleCalendarEventFormatter.standardizeCalendarEvents(events);
    }

    public List<CalendarSetting> getCalendarSettings() {
        List<CalendarListEntry> calendars = new ArrayList<>();
        try {
            com.google.api.services.calendar.Calendar service =
                    GoogleCalendarAuthorization.getCalendarService(userSettingsProvider.getUserSettings().getUsername());

            calendars = service.calendarList()
                    .list()
                    .execute()
                    .getItems();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatter.standardizeCalendarSettings(calendars);
    }

}
