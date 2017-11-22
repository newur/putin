package com.putin.photos;

import com.putin.calendar.model.Calendar;
import com.putin.photos.model.PhotoAlbum;
import com.putin.photos.services.google.GPhotoService;
import com.putin.user.db.UserProvider;
import com.putin.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@RestController
class PhotoService {

    private final GPhotoService gPhotoService;
    private final UserProvider userProvider;

    @Autowired
    public PhotoService(GPhotoService gPhotoService, UserProvider userProvider) {
        this.gPhotoService = gPhotoService;
        this.userProvider = userProvider;
    }

    @RequestMapping("/restGetPhotoUrls")
    public List<String> getPhotoUrls() throws IOException {
        User user = userProvider.getUser();
        List<String> photoUrls = new ArrayList<>();
        List<PhotoAlbum> photoAlbums = user.getPhotoSettings().getPhotoAlbums();
        for(PhotoAlbum photoAlbum : photoAlbums){
            try {
                photoUrls = gPhotoService.getPhotoUrls(user.getUsername(), photoAlbum.getUrl());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return photoUrls;
    }

    @RequestMapping("/restGetPhotoAlbums")
    public List<PhotoAlbum> getPhotoAlbums(@RequestParam("type") String type) throws IOException {
        User user = userProvider.getUser();
        List<PhotoAlbum> availablePhotoAlbums = gPhotoService.getAlbums(user.getUsername());

        Set<String> selectedPhotoAlbumIds =
                user.getPhotoSettings().getPhotoAlbums().stream()
                        .map(PhotoAlbum::getUrl)
                        .collect(toSet());

        return availablePhotoAlbums.stream()
                .filter(photoAlbum -> !selectedPhotoAlbumIds.contains(photoAlbum.getUrl()))
                .collect(toList());
    }

}
