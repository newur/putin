package com.putin.calendar.services.ical4j;

import biweekly.Biweekly;
import biweekly.ICalendar;
import biweekly.component.VEvent;
import biweekly.io.TimezoneAssignment;
import biweekly.io.TimezoneInfo;
import biweekly.util.com.google.ical.compat.javautil.DateIterator;
import com.putin.calendar.model.CalendarEvent;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class BiweeklyService {

    private ICalendar buildCalendar(String url) throws IOException {
        InputStream fin = new URL(url).openStream();
        return Biweekly.parse(fin).first();
    }

    public List<CalendarEvent> getCalendarEvents(String url){
        ICalendar calendar = null;
        try {
            calendar = this.buildCalendar(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return BiweeklyEventFormatter.standardizeCalendarEvents(calendar);
    }



}
