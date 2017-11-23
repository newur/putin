package com.putin.model.clock;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.putin.model.user.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ClockSettings {

    @Id
    @GeneratedValue
    private Long id;
    private String clockType;

    public ClockSettings(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClockType() {
        return clockType;
    }

    public void setClockType(String clockType) {
        this.clockType = clockType;
    }

}
