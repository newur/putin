package com.putin.photos.model;

public class PhotoAlbum {

    private String name;
    private String id;
    private boolean selected;

    public PhotoAlbum(String id, String name, boolean selected) {
        this.name = name;
        this.id = id;
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "PhotoAlbum{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", selected=" + selected +
                '}';
    }
}
