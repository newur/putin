package com.putin.calendar.services.google;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;
import com.putin.calendar.model.CalendarEvent;
import com.putin.user.model.CalendarSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GoogleCalendarService {

    private final GoogleCalendarSettingFormatter formatter;

    @Autowired
    public GoogleCalendarService(GoogleCalendarSettingFormatter formatter) {
        this.formatter = formatter;
    }

    public List<CalendarEvent> getCalendarEvents(String username, String calendarID){
        List<Event> events = new ArrayList<>();
        try {
            com.google.api.services.calendar.Calendar service =
                    GoogleCalendarAuthorization.getCalendarService(username);
            events.addAll(service.events()
                    .list(calendarID)
                    .setMaxResults(30)
                    .setTimeMin(new DateTime(new Date()))
                    .setOrderBy("startTime")
                    .setSingleEvents(true)
                    .execute()
                    .getItems());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return GoogleCalendarEventFormatter.standardizeCalendarEvents(events);
    }

    public List<CalendarSetting> getCalendarSettings(String username) {
        List<CalendarListEntry> calendars = new ArrayList<>();
        try {
            com.google.api.services.calendar.Calendar service =
                    GoogleCalendarAuthorization.getCalendarService(username);

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
