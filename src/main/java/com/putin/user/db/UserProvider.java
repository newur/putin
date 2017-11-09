package com.putin.user.db;

import com.putin.user.model.User;

public interface UserProvider {

    User getUser();
    boolean setUser(User user);

}
