package com.putin.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

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
            System.err.println("File usersettings.yaml not found. New user must be created. Redirecting...");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static void setUserSettings(UserSettings userSettings) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            mapper.writeValue(new File(System.getenv("putin_credentials")+"/usersettings.yaml"), userSettings);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
