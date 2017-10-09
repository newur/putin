package com.putin.user;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class UserSettingsMapperTest {

    @Test
    public void getUserSettingsTest(){

        UserSettings userSettings = UserSettingsMapper.getUserSettings();
        System.out.println(ReflectionToStringBuilder.toString(userSettings, ToStringStyle.MULTI_LINE_STYLE));
        assertNotNull(userSettings);

    }

}
