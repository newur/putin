package com.putin.calendar.services.google;

import com.google.api.services.calendar.model.CalendarListEntry;
import com.putin.calendar.model.Calendar;
import com.putin.calendar.model.Provider;

import java.util.ArrayList;
import java.util.List;

public class GCalendarFormatter {

     public static List<Calendar> standardizeCalendarSettings(List<CalendarListEntry> gCalendars){
        List<Calendar> calendars = new ArrayList<>();
        for (CalendarListEntry entry : gCalendars) {
            calendars.add(new Calendar(Provider.GOOGLE.getName(), entry.getId(), entry.getSummary(), entry.getDescription()));
        }
        return calendars;
    }

}
