package com.putin.calendar.services.google;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;
import com.putin.calendar.model.CalendarEvent;
import com.putin.user.model.CalendarSetting;
import com.putin.user.util.UserSettingsMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoogleCalendarService {

    public static String checkAuthorization(){
        return "";
    }

    public static List<CalendarEvent> getCalendarEvents(){
        List<Event> events = new ArrayList<>();
        for(CalendarSetting calendarSetting : UserSettingsMapper.getUserSettings().getCalendarSettings()) {
            if(calendarSetting.isSelected()) {
                try {
                    com.google.api.services.calendar.Calendar service =
                            GoogleCalendarAuthorization.getCalendarService(UserSettingsMapper.getUserSettings().getUsername());
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

    public static List<CalendarSetting> getCalendarSettings() {
        List<CalendarListEntry> calendars = new ArrayList<>();
        try {
            com.google.api.services.calendar.Calendar service =
                    GoogleCalendarAuthorization.getCalendarService(UserSettingsMapper.getUserSettings().getUsername());

            calendars = service.calendarList()
                    .list()
                    .execute()
                    .getItems();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return GoogleCalendarSettingFormatter.standardizeCalendarSettings(calendars);
    }

}
