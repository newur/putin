package com.putin.user;

import com.putin.authorization.services.google.GAuthorizationService;
import com.putin.calendar.services.google.GCalendarService;
import com.putin.user.db.FileBasedUserProvider;
import com.putin.user.db.UserProvider;
import com.putin.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
class UserService {

    private final GAuthorizationService gAuthorizationService;
    private final UserProvider userProvider;

    @Autowired
    public UserService(GAuthorizationService gAuthorizationService) {
        this.userProvider = new FileBasedUserProvider();
        this.gAuthorizationService = gAuthorizationService;
    }

    @RequestMapping("/restAuthorize")
    public String authorize() throws IOException {
        User user = userProvider.getUser();
        if(user==null)
            return "http://localhost:8080/createUser.html";
        else{
            return gAuthorizationService.checkGoogleAuthorization(user.getUsername());
        }
    }

    @RequestMapping("/restCreateUser")
    public boolean createUser(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email){
        userProvider.setUser(new User(username, password, email));
        return true;
    }

    @RequestMapping("/restGetUser")
    public User getUser(){
        return userProvider.getUser();
    }

    @ResponseBody
    @RequestMapping("/restSaveUser")
    public User saveUser(@RequestBody User user){
        userProvider.setUser(user);
        return userProvider.getUser();
    }

}
