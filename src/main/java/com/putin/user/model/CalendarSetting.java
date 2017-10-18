package com.putin.user.model;

public class CalendarSetting {

    private String type;
    private String id;
    private String name;
    private String description;
    private String color;
    private boolean selected;

    public CalendarSetting() {
        // TODO
    }

    public CalendarSetting(String type, String id, String name, String description, String color, boolean selected) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.description = description;
        this.color = color;
        this.selected = selected;
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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}