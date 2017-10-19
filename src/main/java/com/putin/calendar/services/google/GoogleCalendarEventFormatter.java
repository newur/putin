package com.putin.calendar.services.google;

import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.putin.calendar.model.CalendarEvent;
import com.putin.user.model.CalendarSetting;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class GoogleCalendarEventFormatter {

        static List<CalendarEvent> standardizeCalendarEvents(List<Event> events){
            List<CalendarEvent> calendarEvents= new ArrayList<>();
            for(Event event : events){
                calendarEvents.add(new CalendarEvent(event.getSummary(), event.getDescription(), event.getLocation(),
                        datetimetoDate(event.getStart()), datetimetoDate(event.getEnd()), isAllDayEvent(event)));
            }
            return calendarEvents;
        }        

        private static boolean isAllDayEvent(Event event){
            return event.getStart().getDateTime() == null && event.getStart().getDate() != null;
        }

        private static Date datetimetoDate(EventDateTime datetime){
        if(datetime==null)
            return null;
        else if(datetime.getDateTime()==null && datetime.getDate()!=null)
            try {
                String target = datetime.getDate().toStringRfc3339();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                return df.parse(target);
            } catch (ParseException e) {
                return null;
            }
        else{
            try {
                String target = datetime.getDateTime().toStringRfc3339();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSS");
                return df.parse(target);
            } catch (ParseException e) {
                return null;
            }
        }
    }


}
