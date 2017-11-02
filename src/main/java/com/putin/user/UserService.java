package com.putin.user;

import com.putin.authorization.services.google.GAuthorizationService;
import com.putin.calendar.services.google.*;
import com.putin.user.model.CalendarSetting;
import com.putin.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
class UserService {

    private final GAuthorizationService gAuthorizationService;
    private final GCalendarService gCalendarService;
    private final UserProvider userProvider;

    @Autowired
    public UserService(GAuthorizationService gAuthorizationService, GCalendarService gCalendarService) {
        this.userProvider = new FileBasedUserProvider();
        this.gAuthorizationService = gAuthorizationService;
        this.gCalendarService = gCalendarService;
    }

    @RequestMapping("/userExists")
    public boolean userexists(){
        User user = userProvider.getUserSettings();
        return (user != null);
    }

    @RequestMapping("/getUser")
    public User getusersettings(){
        return userProvider.getUserSettings();
    }

    @ResponseBody
    @RequestMapping("/saveUserSettings")
    public boolean saveUserSettings(@RequestBody User user){
        return userProvider.setUserSettings(user);
    }

    @RequestMapping("/createUserSettings")
    public boolean createUser(@RequestParam("username") String username){
        User user = new User();
        user.setUsername(username);
        user.setPictureTime(10);
        userProvider.setUserSettings(user);
        return true;
    }

    @RequestMapping("/checkGoogleAuthorization")
    public String checkGoogleAuthorization() {
        User user = userProvider.getUserSettings();
        if(gAuthorizationService.checkAuthorization(user.getUsername()) != null){
            updateCalendarSettings();
            return "success";
        }
        else
            return gAuthorizationService.getGoogleLoginUri("http://localhost:8080/authorize");
    }

    @RequestMapping("/authorize")
    public void handleReturnCode(HttpServletResponse response, @RequestParam("code") String code) throws IOException {
        try {
            gAuthorizationService.authorize(userProvider.getUserSettings().getUsername(), code, "http://localhost:8080/authorize");

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("http://localhost:8080/index.html");
    }


    private void updateCalendarSettings() {
        User user = userProvider.getUserSettings();
        List<CalendarSetting> calendarsSettings = gCalendarService.getCalendarSettings(user.getUsername());
        user.setCalendarSettings(calendarsSettings);
        userProvider.setUserSettings(user);
    }

}
