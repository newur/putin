package com.putin.calendarservice;

import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;
import com.putin.user.UserSettings;
import com.putin.user.UserSettingsMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CalendarWebServiceTest {

    @Test
    public void getCalendarsTest(){
        CalendarWebService calendarWebService = new CalendarWebService();
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
        CalendarWebService calendarWebService = new CalendarWebService();
        List<Event> events = new ArrayList<Event>();
        try {
            events = (List<Event>) calendarWebService.getEvents(UserSettingsMapper.getUserSettings().getUsername(),
                    UserSettingsMapper.getUserSettings().getSelectedCalendars().get(0)).getEntity();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert !events.isEmpty();
        for(Event event : events){
            System.out.println(event.getSummary());
        }
    }

}
