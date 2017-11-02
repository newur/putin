package com.putin.photos;

import com.google.gdata.util.ServiceException;
import com.putin.calendar.model.CalendarDay;
import com.putin.calendar.model.CalendarEvent;
import com.putin.calendar.services.google.GCalendarService;
import com.putin.calendar.util.CalendarDayBuilder;
import com.putin.calendar.util.CalendarEventAdapter;
import com.putin.photos.services.google.GPhotoService;
import com.putin.user.UserProvider;
import com.putin.user.model.CalendarSetting;
import com.putin.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
class PhotoService {

    private final GPhotoService gPhotoService;
    private final UserProvider userProvider;

    @Autowired
    public PhotoService(GPhotoService gPhotoService, UserProvider userProvider) {
        this.gPhotoService = gPhotoService;
        this.userProvider = userProvider;
    }

    @RequestMapping("/photoUrls")
    public List<String> getAllCalendarEvents(){
        User user = userProvider.getUserSettings();
        List<String> photoUrls = new ArrayList<>();
        try {
            photoUrls = gPhotoService.getPhotoUrls(userProvider.getUserSettings().getUsername(), "lapotschka.putin@gmail.com", "6481690100628020145");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return photoUrls;
    }

}
