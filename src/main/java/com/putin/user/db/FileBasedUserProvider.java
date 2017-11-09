package com.putin.user.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.putin.user.model.User;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;

@Service
public class FileBasedUserProvider implements UserProvider {

    @Override
    public User getUser() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        User user;
        try {
            user = mapper.readValue(new File(System.getenv("putin_credentials")+"/usersettings.yaml"), User.class);
            return user;
        } catch (FileNotFoundException e) {
            System.err.println("File usersettings.yaml not found.");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean setUser(User user) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            mapper.writeValue(new File(System.getenv("putin_credentials")+"/usersettings.yaml"), user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
