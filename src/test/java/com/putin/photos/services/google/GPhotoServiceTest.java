package com.putin.photos.services.google;

import com.google.gdata.util.ServiceException;
import com.putin.authorization.services.google.GAuthorizationService;
import com.putin.photos.model.PhotoAlbum;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class GPhotoServiceTest {

    @Test
    public void getAlbumsTest() throws IOException, ServiceException {

        GAuthorizationService gAuthorizationService = new GAuthorizationService();
        GPhotoService gPhotoService = new GPhotoService(gAuthorizationService);
        List<PhotoAlbum> photoAlbums = gPhotoService.getAlbums("Vladi", "lapotschka.putin@gmail.com");
        photoAlbums.forEach(photoAlbum -> System.out.println(photoAlbum.toString()));

    }

    @Test
    public void getPhotosTest() throws IOException, ServiceException {

        GAuthorizationService gAuthorizationService = new GAuthorizationService();
        GPhotoService gPhotoService = new GPhotoService(gAuthorizationService);
        List<PhotoAlbum> photoAlbums = gPhotoService.getAlbums("Vladi", "lapotschka.putin@gmail.com");
        for(PhotoAlbum photoAlbum : photoAlbums){
            System.out.println(photoAlbum.getName());
            List<String> photoUrls = gPhotoService.getPhotoUrls("Vladi", "lapotschka.putin@gmail.com",
                    photoAlbum.getId());
            photoUrls.forEach(photoUrl -> System.out.println(photoUrl));
        }

    }


}
