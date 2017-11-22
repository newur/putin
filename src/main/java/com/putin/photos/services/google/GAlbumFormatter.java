package com.putin.photos.services.google;

import com.google.gdata.data.photos.GphotoEntry;
import com.putin.photos.model.PhotoAlbum;
import com.putin.photos.model.PhotoProvider;

import java.util.ArrayList;
import java.util.List;

public class GAlbumFormatter {

    public static List<PhotoAlbum> getPhotoAlbums(List<GphotoEntry> gphotoEntries){
        List<PhotoAlbum> photoAlbums = new ArrayList<>();
        for(GphotoEntry gphotoEntry : gphotoEntries){
            photoAlbums.add(new PhotoAlbum(PhotoProvider.GOOGLE.getName(), gphotoEntry.getTitle().getPlainText(), gphotoEntry.getGphotoId()));
        }
        return photoAlbums;
    }

}
