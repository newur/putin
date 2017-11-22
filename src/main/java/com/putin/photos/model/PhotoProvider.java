package com.putin.photos.model;


public enum PhotoProvider {

    GOOGLE("google");

    private String name;

    PhotoProvider(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
