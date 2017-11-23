package com.putin.database;

import com.putin.model.authorization.GoogleCredentials;
import com.putin.model.user.User;

public interface UserProvider {

    User getUser();
    boolean setUser(User user);
    boolean setGoogleCredentials(GoogleCredentials googleCredentials);

}
