package com.putin.user.db;

import com.putin.repository.UserRepository;
import com.putin.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class UserProviderImpl implements UserProvider {

    private UserRepository userRepository;

    @Autowired
    public UserProviderImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser() {
        List<User> users = userRepository.findAll();
        return users.size() > 0 ? users.get(0) : new User();
    }

    @Override
    public boolean setUser(User user) {
        userRepository.save(user);
        return true;
    }
}
