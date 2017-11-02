package com.putin.photos.services.google;

import com.google.gdata.data.photos.GphotoEntry;
import com.putin.photos.model.PhotoAlbum;

import java.util.ArrayList;
import java.util.List;

public class GAlbumFormatter {

    public static List<PhotoAlbum> getPhotoAlbums(List<GphotoEntry> gphotoEntries){
        List<PhotoAlbum> photoAlbums = new ArrayList<>();
        for(GphotoEntry gphotoEntry : gphotoEntries){
            photoAlbums.add(new PhotoAlbum(gphotoEntry.getGphotoId(), gphotoEntry.getTitle().getPlainText(), false));
        }
        return photoAlbums;
    }

}
