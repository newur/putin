package com.putin.user;

import com.putin.calendarservice.CalendarSetting;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class UserSettingsMapperTest {

    @Test
    public void getUserSettingsTest(){

        UserSettings userSettings = UserSettingsMapper.getUserSettings();
        System.out.println(ReflectionToStringBuilder.toString(userSettings, ToStringStyle.MULTI_LINE_STYLE));
        assertNotNull(userSettings);

    }

    @Test
    public void setUserSettingsTest(){

        UserSettings userSettings = new UserSettings();

        userSettings.setUsername("johanneshartig@gmail.com");

        List<CalendarSetting> calendarSettings = new ArrayList<CalendarSetting>();
        calendarSettings.add (new CalendarSetting("google","johanneshartig@gmail.com", null, null, true));
        calendarSettings.add (new CalendarSetting("google","#contacts@group.v.calendar.google.com", null, null, true));
        userSettings.setCalendarSettings(calendarSettings);

        UserSettingsMapper.setUserSettings(userSettings);
    }

}
