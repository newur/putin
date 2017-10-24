package com.putin.integration;

import com.putin.utils.GeckoDriverFinder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AbstractSeleniumTest {

    public static WebDriver driver;
    public static WebDriverWait wait;


    @BeforeClass
    public static void setUpBeforeClass() {
        System.setProperty("webdriver.gecko.driver", GeckoDriverFinder.findGeckoDriverForOS());
        initWebDriverAndWait();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    private static void initWebDriverAndWait() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 10);
    }
}
