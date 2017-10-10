package com.putin.calendarservice;

import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;
import com.putin.calendarservice.googlecalendar.GoogleCalendarWebService;
import com.putin.user.UserSettingsMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GoogleCalendarWebServiceTest {

    @Test
    public void getCalendarsTest(){
        GoogleCalendarWebService calendarWebService = new GoogleCalendarWebService();
        List<CalendarListEntry> calendars = new ArrayList<CalendarListEntry>();
        try {
            calendars = (List<CalendarListEntry>) calendarWebService.getCalendars("johanneshartig@gmail.com").getEntity();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert !calendars.isEmpty();
        for(CalendarListEntry calendarListEntry : calendars){
            System.out.println(calendarListEntry.getSummary() + " - " +calendarListEntry.getId());
        }
    }

    @Test
    public void getEventsTest(){
        GoogleCalendarWebService calendarWebService = new GoogleCalendarWebService();
        List<Event> events = new ArrayList<Event>();
        try {
            events = (List<Event>) calendarWebService.getEvents(UserSettingsMapper.getUserSettings().getUsername(),
                    UserSettingsMapper.getUserSettings().getCalendarSettings().get(0).getId()).getEntity();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert !events.isEmpty();
        for(Event event : events){
            System.out.println(event.getSummary());
        }
    }

}
