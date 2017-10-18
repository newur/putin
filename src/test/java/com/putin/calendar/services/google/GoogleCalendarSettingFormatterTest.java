package com.putin.calendar.services.google;

import com.putin.user.UserSettingsProvider;
import org.junit.Test;
import org.mockito.Mockito;

public class GoogleCalendarSettingFormatterTest {

    @Test
    public void testOnlyReturnSelected(){

        UserSettingsProvider userSettingsProvider = Mockito.mock(UserSettingsProvider.class);
        GoogleCalendarSettingFormatter formatter = new GoogleCalendarSettingFormatter(userSettingsProvider);

        //formatter.checkCalendarSelection()
    }

}