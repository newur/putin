package com.putin.selenium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ruwen on 17.10.17.
 */
@RestController
@RequestMapping("rest/selenium")
public class SeleniumDemoRestController {

    @Autowired
    SeleniumService seleniumService;

    @GetMapping
    @RequestMapping("demo")
    public List<String> findPicUrlsDemo() {
        return seleniumService.findPictureUrlsFromFirstAlbum();
    }
}