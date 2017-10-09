package com.putin.calendarservice;

import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EventFormatter {

        private static Date datetimetoDate(EventDateTime datetime){
        if(datetime==null)
            return null;
        else if(datetime.getDateTime()==null && datetime.getDate()!=null)
            try {
                String target = datetime.getDate().toStringRfc3339();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date result = df.parse(target);
                return result;
            } catch (ParseException e) {
                return null;
            }
        else{
            try {
                String target = datetime.getDateTime().toStringRfc3339();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSS");
                Date result = df.parse(target);
                return result;
            } catch (ParseException e) {
                return null;
            }
        }
    }

    private static String dateToString(EventDateTime datetime){
        if(datetime==null)
            return "";
        else if(datetime.getDateTime()==null && datetime.getDate()!=null)
            try {
                String target = datetime.getDate().toStringRfc3339();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date result = df.parse(target);
                DateFormat df2 = new SimpleDateFormat("EEEE, dd.MMMMM", Locale.GERMAN);
                return df2.format(result);
            } catch (ParseException e) {
                return "";
            }
        else{
            try {
                String target = datetime.getDateTime().toStringRfc3339();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSS");
                Date result = df.parse(target);
                DateFormat df2 = new SimpleDateFormat("EEEE, dd.MMMMM", Locale.GERMAN);
                return df2.format(result);
            } catch (ParseException e) {
                return "";
            }
        }

    }


}
