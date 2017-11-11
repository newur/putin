package com.putin.calendar.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Calendar {

    @Id
    @GeneratedValue
    private String id;

    private String type;
    private String name;
    private String description;
    private String color;

    public Calendar() {
        // TODO
    }

    public Calendar(String type, String id, String name, String description) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
