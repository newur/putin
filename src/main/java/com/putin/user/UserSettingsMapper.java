package com.putin.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.File;

public class UserSettingsMapper {

    public static UserSettings getUserSettings() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        UserSettings userSettings = new UserSettings();
        try {
            userSettings = mapper.readValue(new File(System.getenv("putin_credentials")+"/usersettings.yaml"), UserSettings.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userSettings;
    }

    public static void setUserSettings(UserSettings userSettings) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            mapper.writeValue(new File(System.getenv("putin_credentials")+"/usersettings.yaml"), userSettings);
            System.out.println(ReflectionToStringBuilder.toString(userSettings, ToStringStyle.MULTI_LINE_STYLE));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
