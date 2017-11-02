package com.putin.user;

import com.putin.user.model.User;

public interface UserProvider {

    User getUserSettings();
    boolean setUserSettings(User user);

}
