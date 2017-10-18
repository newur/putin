package com.putin.selenium.config;

import com.putin.utils.GeckoDriverFinder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeleniumConfig {

//    @Bean
//    public WebDriver webDriver() {
//        System.setProperty("webdriver.gecko.driver", GeckoDriverFinder.findGeckoDriverForOS());
//        return new FirefoxDriver();
//    }
//
//    @Bean
//    public WebDriverWait webDriverWait() {
//        return new WebDriverWait(webDriver(), 10);
//    }
}
