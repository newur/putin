package com.putin.calendar.model;

public class Calendar {

    private String type;
    private String id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
