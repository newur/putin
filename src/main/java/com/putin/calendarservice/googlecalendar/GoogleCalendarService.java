package com.putin.calendarservice.googlecalendar;

import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;
import com.putin.calendarservice.CalendarEvent;
import com.putin.calendarservice.CalendarSetting;
import com.putin.user.UserSettingsMapper;

import java.util.ArrayList;
import java.util.List;

public class GoogleCalendarService {

    public static List<CalendarEvent> getCalendarEvents(){
        GoogleCalendarWebService calendarWebService = new GoogleCalendarWebService();
        List<Event> events = new ArrayList<>();
        for(CalendarSetting calendarSetting : UserSettingsMapper.getUserSettings().getCalendarSettings()) {
            if(calendarSetting.isSelected()) {
                try {
                    events = (List<Event>) calendarWebService.getEvents(UserSettingsMapper.getUserSettings().getUsername(), calendarSetting.getId()).getEntity();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return GoogleCalendarEventFormatter.standardizeCalendarEvents(events);
    }

    public static List<CalendarSetting> getCalendarSettings() {
        GoogleCalendarWebService calendarWebService = new GoogleCalendarWebService();
        List<CalendarListEntry> calendars = new ArrayList<>();
        try {
            calendars = (List<CalendarListEntry>) calendarWebService.getCalendars(UserSettingsMapper.getUserSettings().getUsername()).getEntity();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return GoogleCalendarSettingFormatter.standardizeCalendarSettings(calendars);
    }

}
