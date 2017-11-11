package com.putin.photos.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class PhotoAlbum {

    @Id
    @GeneratedValue
    private String id;

    private String name;
    private boolean selected;

    public PhotoAlbum(String id, String name, boolean selected) {
        this.name = name;
        this.id = id;
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
