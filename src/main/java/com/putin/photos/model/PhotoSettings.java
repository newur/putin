package com.putin.photos.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PhotoSettings {

    @Id
    @GeneratedValue
    private Long id;

    public PhotoSettings(){
        //TODO
    }

    private int photoTransitionTime;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<PhotoAlbum> photoAlbums = new ArrayList<>();

    public int getPhotoTransitionTime() {
        return photoTransitionTime;
    }

    public void setPhotoTransitionTime(int photoTransitionTime) {
        this.photoTransitionTime = photoTransitionTime;
    }

    public List<PhotoAlbum> getPhotoAlbums() {
        return photoAlbums;
    }

    public void setPhotoAlbums(List<PhotoAlbum> photoAlbums) {
        this.photoAlbums = photoAlbums;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
