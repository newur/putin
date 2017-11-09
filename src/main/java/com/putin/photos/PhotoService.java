package com.putin.photos;

import com.putin.photos.services.google.GPhotoService;
import com.putin.user.db.UserProvider;
import com.putin.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        try {
            photoUrls = gPhotoService.getPhotoUrls(userProvider.getUser().getUsername(), "lapotschka.putin@gmail.com", "6481690100628020145");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return photoUrls;
    }

}
