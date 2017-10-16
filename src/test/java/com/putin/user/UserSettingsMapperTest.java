package com.putin.user;

import com.putin.user.model.CalendarSetting;
import com.putin.user.model.UserSettings;
import com.putin.user.util.UserSettingsMapper;
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
        userSettings.setUsername("vladi");
        List<CalendarSetting> calendarSettings = new ArrayList<CalendarSetting>();
        userSettings.setCalendarSettings(calendarSettings);
        UserSettingsMapper.setUserSettings(userSettings);
    }

}
