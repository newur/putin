package com.putin.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.putin.user.UserSettingsProvider;
import com.putin.user.model.UserSettings;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;

@Service
public class FileBasedUserSettingsProvider implements UserSettingsProvider {

    @Override
    public UserSettings getUserSettings() {
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

    @Override
    public boolean setUserSettings(UserSettings userSettings) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            mapper.writeValue(new File(System.getenv("putin_credentials")+"/usersettings.yaml"), userSettings);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
