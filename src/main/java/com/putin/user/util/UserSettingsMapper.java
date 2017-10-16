package com.putin.user.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.putin.user.model.UserSettings;

import java.io.File;
import java.io.FileNotFoundException;

public class UserSettingsMapper {

    public static UserSettings getUserSettings() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        UserSettings userSettings;
        try {
            userSettings = mapper.readValue(new File(System.getenv("putin_credentials")+"/usersettings.yaml"), UserSettings.class);
            return userSettings;
        } catch (FileNotFoundException e) {
            System.err.println("File usersettings.yaml not found.");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setUserSettings(UserSettings userSettings) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            mapper.writeValue(new File(System.getenv("putin_credentials")+"/usersettings.yaml"), userSettings);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
