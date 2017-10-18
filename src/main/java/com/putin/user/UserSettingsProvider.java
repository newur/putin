package com.putin.user;

import com.putin.user.model.UserSettings;

public interface UserSettingsProvider {

    UserSettings getUserSettings();
    boolean setUserSettings(UserSettings userSettings);

}
