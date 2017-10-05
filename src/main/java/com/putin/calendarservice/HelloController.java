package com.putin.calendarservice;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping("/de")
    public String sayHello() {
        return "Hallo Welt!";
    }

}