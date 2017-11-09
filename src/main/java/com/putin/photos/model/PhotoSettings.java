package com.putin.photos.model;

import java.util.ArrayList;
import java.util.List;

public class PhotoSettings {

    public PhotoSettings(){
        //TODO
    }

    private int photoTransitionTime;
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
}
