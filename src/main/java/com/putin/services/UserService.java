package com.putin.services;

import com.putin.provider.authorization.GAuthorizationService;
import com.putin.model.calendar.Calendar;
import com.putin.model.photos.PhotoAlbum;
import com.putin.database.UserProvider;
import com.putin.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
class UserService {

    private final GAuthorizationService gAuthorizationService;
    private final UserProvider userProvider;

    @Autowired
    public UserService(GAuthorizationService gAuthorizationService, UserProvider userProvider) {
        this.userProvider = userProvider;
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
        User user = new User(username,password,email);
        userProvider.setUser(user);
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
