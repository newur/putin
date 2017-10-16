package com.putin.user;

import com.putin.user.model.CalendarSetting;
import com.putin.calendar.services.google.GoogleCalendarAuthorization;
import com.putin.calendar.services.google.GoogleCalendarService;
import com.putin.user.model.UserSettings;
import com.putin.user.util.UserSettingsMapper;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class UserSettingsService {

    @RequestMapping("/userExists")
    private static boolean userexists(){
        UserSettings userSettings = UserSettingsMapper.getUserSettings();
        return (userSettings != null);
    }

    @RequestMapping("/getUser")
    private UserSettings getusersettings(){
        return UserSettingsMapper.getUserSettings();
    }

    @ResponseBody
    @RequestMapping("/saveUserSettings")
    public boolean saveUserSettings(@RequestBody UserSettings userSettings){
        UserSettingsMapper.setUserSettings(userSettings);
        return true;
    }

    @RequestMapping("/createUserSettings")
    public boolean createUser(@RequestParam("username") String username){
        UserSettings userSettings = new UserSettings();
        userSettings.setUsername(username);
        UserSettingsMapper.setUserSettings(userSettings);
        return true;
    }

    @RequestMapping("/checkGoogleAuthorization")
    public String checkGoogleAuthorization() {
        UserSettings userSettings = UserSettingsMapper.getUserSettings();
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
            GoogleCalendarAuthorization.authorize(code, "http://localhost:8080/authorize");

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("http://localhost:8080/index.html");
    }


    private void updateCalendarSettings() {
        List<CalendarSetting> calendarsSettings = GoogleCalendarService.getCalendarSettings();
        UserSettings userSettings = UserSettingsMapper.getUserSettings();
        userSettings.setCalendarSettings(calendarsSettings);
        UserSettingsMapper.setUserSettings(userSettings);
    }

}
