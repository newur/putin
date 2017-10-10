package com.putin.calendarservice.googlecalendar;

import com.putin.calendarservice.googlecalendar.GoogleCalendarAuthorization;
import org.junit.Test;

public class GoogleCalendarAuthorizationTest {

    @Test
    public void testAuthorization(){
        GoogleCalendarAuthorization calendarRequest = new GoogleCalendarAuthorization();
        try {
            calendarRequest.authorize("johanneshartig@gmail.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
