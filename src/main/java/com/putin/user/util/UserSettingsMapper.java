package com.putin.user.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.putin.user.model.UserSettings;

import java.io.File;
import java.io.FileNotFoundException;

import static org.apache.commons.lang3.StringUtils.*;

public class UserSettingsMapper {

    public static UserSettings getUserSettings() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        UserSettings userSettings;
        try {
            userSettings = mapper.readValue(new File(getUserSettingsYaml()), UserSettings.class);
            return userSettings;
        } catch (FileNotFoundException e) {
            System.err.println("File usersettings.yaml not found. New user must be created. Redirecting...");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setUserSettings(UserSettings userSettings) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            mapper.writeValue(new File(getUserSettingsYaml()), userSettings);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUserSettingsYaml() {
        return getPathToUserSettingsOrFallbackToHomeDir() + "/usersettings.yaml";
    }

    public static String getPathToUserSettingsOrFallbackToHomeDir() {
        String putinCredentialsPath = System.getenv("putin_credentials");

        return isEmpty(putinCredentialsPath) ? System.getProperty("user.home") : putinCredentialsPath;
    }

}
