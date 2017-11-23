package com.putin.database;

import com.putin.model.authorization.GoogleCredentials;
import com.putin.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class DatabaseUserProvider implements UserProvider {

    private UserRepository userRepository;
    private GoogleCredentialsRepository googleCredentialsRepository;

    @Autowired
    public DatabaseUserProvider(UserRepository userRepository, GoogleCredentialsRepository googleCredentialsRepository) {
        this.userRepository = userRepository;
        this.googleCredentialsRepository = googleCredentialsRepository;
    }

    @Override
    public User getUser() {
        List<User> users = userRepository.findAll();
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public boolean setUser(User user) {
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean setGoogleCredentials(GoogleCredentials googleCredentials) {
        googleCredentialsRepository.save(googleCredentials);
        return true;
    }

}
