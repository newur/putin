package com.putin.user;

import com.putin.calendar.services.google.*;
import com.putin.user.model.CalendarSetting;
import com.putin.user.model.UserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class UserSettingsService {

    private final GoogleCalendarService googleCalendarService;
    private final UserSettingsProvider userSettingsProvider;

    @Autowired
    public UserSettingsService() {
        this.userSettingsProvider = new FileBasedUserSettingsProvider();
        this.googleCalendarService = new GoogleCalendarService(new GoogleCalendarSettingFormatter(userSettingsProvider),userSettingsProvider);
    }

    @RequestMapping("/userExists")
    public boolean userexists(){
        UserSettings userSettings = userSettingsProvider.getUserSettings();
        return (userSettings != null);
    }

    @RequestMapping("/getUser")
    public UserSettings getusersettings(){
        return userSettingsProvider.getUserSettings();
    }

    @ResponseBody
    @RequestMapping("/saveUserSettings")
    public boolean saveUserSettings(@RequestBody UserSettings userSettings){
        return userSettingsProvider.setUserSettings(userSettings);
    }

    @RequestMapping("/createUserSettings")
    public boolean createUser(@RequestParam("username") String username){
        UserSettings userSettings = new UserSettings();
        userSettings.setUsername(username);
        userSettingsProvider.setUserSettings(userSettings);
        return true;
    }

    @RequestMapping("/checkGoogleAuthorization")
    public String checkGoogleAuthorization() {
        UserSettings userSettings = userSettingsProvider.getUserSettings();
        if(GoogleCalendarAuthorization.checkAuthorization(userSettings.getUsername()) != null){
            updateCalendarSettings();
            return "success";
        }
        else
            return GoogleCalendarAuthorization.getGoogleLoginUri(userSettings.getUsername(),"http://localhost:8080/authorize");
    }

    @RequestMapping("/authorize")
    public void handleReturnCode(HttpServletResponse response, @RequestParam("code") String code) throws IOException {
        try {
            GoogleCalendarAuthorization.authorize(userSettingsProvider.getUserSettings().getUsername(), code, "http://localhost:8080/authorize");

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("http://localhost:8080/index.html");
    }


    private void updateCalendarSettings() {
        List<CalendarSetting> calendarsSettings = googleCalendarService.getCalendarSettings();
        UserSettings userSettings = userSettingsProvider.getUserSettings();
        userSettings.setCalendarSettings(calendarsSettings);
        userSettingsProvider.setUserSettings(userSettings);
    }

}
