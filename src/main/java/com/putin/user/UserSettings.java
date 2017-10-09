package com.putin.user;

import java.util.List;

public class UserSettings {

    private String username;
    private List<String> selectedCalendars;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getSelectedCalendars() {
        return selectedCalendars;
    }

    public void setSelectedCalendars(List<String> selectedCalendars) {
        this.selectedCalendars = selectedCalendars;
    }
}
