package com.putin.photos.services.google;

import com.google.gdata.util.ServiceException;
import org.junit.Test;

import java.io.IOException;

public class GooglePhotoServiceTest {

    @Test
    public void getAlbumsTest() throws IOException, ServiceException {

        GooglePhotoService googlePhotoService = new GooglePhotoService();
        googlePhotoService.getAlbums();

    }

    @Test
    public void getPhotosTest() throws IOException, ServiceException {

        GooglePhotoService googlePhotoService = new GooglePhotoService();
        googlePhotoService.getPhotos();

    }

}
