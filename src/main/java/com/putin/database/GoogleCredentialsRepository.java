package com.putin.database;

import com.putin.model.authorization.GoogleCredentials;
import com.putin.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoogleCredentialsRepository extends JpaRepository<GoogleCredentials, Long> {

//    void saveAccessToken(User user, String token);

}
