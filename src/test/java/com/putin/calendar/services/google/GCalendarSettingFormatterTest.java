package com.putin.calendar.services.google;

import com.putin.user.UserProvider;
import org.junit.Test;
import org.mockito.Mockito;

public class GCalendarSettingFormatterTest {

    @Test
    public void testOnlyReturnSelected(){

        UserProvider userProvider = Mockito.mock(UserProvider.class);
        GCalendarSettingFormatter formatter = new GCalendarSettingFormatter(userProvider);

    }

}