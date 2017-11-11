package com.putin.clock.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class ClockSettings {

    @Id
    @GeneratedValue
    private Long id;

    private String clockType;

}
