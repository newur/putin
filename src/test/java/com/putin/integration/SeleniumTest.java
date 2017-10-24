package com.putin.integration;

import com.putin.integration.AbstractSeleniumTest;
import com.putin.utils.StringTransformer;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by ruwen on 03.10.17.
 */
public class SeleniumTest extends AbstractSeleniumTest {

    private String googleUser;
    private String googlePassword;

    @Before
    public void setUp() {
        initUserAndPasswordFromEnvironmentVariables();
    }

    @Test
    public void openFirstAlbumTest() throws Exception {
        driver.navigate().to("https://photos.google.com/albums");

        login();

        openFirstAlbum();

        List<String> imageUrls = extractImageUrlsFromCurrentPage();

        imageUrls.forEach(System.out::println);
    }

    private List<String> extractImageUrlsFromCurrentPage() {
        List<WebElement> cssElements = wait.until(elementsVisibleWithClassName("RY3tic"));

        return cssElements.stream()
                .map(image -> image.getCssValue("background-image"))
                .map(StringTransformer::getURLfromCssValue)
                .collect(Collectors.toList());
    }

    private void openFirstAlbum() {
        List<WebElement> albums = wait.until(elementsVisibleWithClassName("MTmRkb"));

        if (albums.size() > 1) {
            albums.get(1).click();
        }
    }

    private ExpectedCondition<List<WebElement>> elementsVisibleWithClassName(String className) {
        return ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(className));
    }

    private void login() {
        WebElement identifier = driver.findElement(By.name("identifier"));
        identifier.sendKeys(googleUser);
        identifier.sendKeys(Keys.ENTER);

        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
        password.sendKeys(googlePassword);
        password.sendKeys(Keys.ENTER);
    }

    @Test
    public void openGoogle() {
        driver.navigate().to("https://google.com");
    }

    private void initWebDriverAndWait() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 10);
    }

    private void initUserAndPasswordFromEnvironmentVariables() {
        googleUser = System.getenv("GOOGLE_USER");
        googlePassword = System.getenv("GOOGLE_PASSWORD");
        if (googleUser == null || googlePassword == null) {
            throw new RuntimeException("Please make sure environment variables GOOGLE_USER and GOOGLE_PASSWORD are set");
        }
    }
}
