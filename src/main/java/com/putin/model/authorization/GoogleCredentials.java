package com.putin.model.authorization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.putin.model.user.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class GoogleCredentials {

    @Id
    @GeneratedValue
    private Long id;

    private String accessToken;
    private String refreshToken;

    public GoogleCredentials(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

}
