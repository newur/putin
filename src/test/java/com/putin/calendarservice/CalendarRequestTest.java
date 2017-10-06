package com.putin.calendarservice;

import org.junit.Test;

public class CalendarRequestTest {

    @Test
    public void testAuthorization(){
        CalendarRequest calendarRequest = new CalendarRequest();
        try {
            calendarRequest.authorize("johanneshartig@gmail.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
