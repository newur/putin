package com.putin.calendarservice;

import com.putin.calendarservice.googlecalendar.GoogleCalendarRequest;
import org.junit.Test;

public class GoogleCalendarRequestTest {

    @Test
    public void testAuthorization(){
        GoogleCalendarRequest calendarRequest = new GoogleCalendarRequest();
        try {
            calendarRequest.authorize("johanneshartig@gmail.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
