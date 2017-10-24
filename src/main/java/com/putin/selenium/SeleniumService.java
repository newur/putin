package com.putin.selenium;

import com.putin.utils.GeckoDriverFinder;
import com.putin.utils.StringTransformer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeleniumService {

    private WebDriver driver;
    private WebDriverWait wait;

    private String googleUser;
    private String googlePassword;

    SeleniumService() {
        System.setProperty("webdriver.gecko.driver", GeckoDriverFinder.findGeckoDriverForOS());
        initUserAndPasswordFromEnvironmentVariables();
    }

    private void initSelenium() {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("-headless");

        this.driver = new FirefoxDriver(new FirefoxOptions().setBinary(firefoxBinary));
        this.wait = new WebDriverWait(driver, 10);
    }

    public List<String> findPictureUrlsFromFirstAlbum() {
        initSelenium();

        driver.navigate().to("https://photos.google.com/albums");

        login();
        openFirstAlbum();
        List<String> urls = extractImageUrlsFromCurrentPage();
        driver.quit();
        return urls;
    }

    private void login() {
        WebElement identifier = driver.findElement(By.name("identifier"));
        identifier.sendKeys(googleUser);
        identifier.sendKeys(Keys.ENTER);

        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
        password.sendKeys(googlePassword);
        password.sendKeys(Keys.ENTER);
    }

    private void openFirstAlbum() {
        List<WebElement> albums = wait.until(elementsVisibleWithClassName("MTmRkb"));

        if (albums.size() > 1) {
            albums.get(1).click();
        }
    }

    private List<String> extractImageUrlsFromCurrentPage() {
        List<WebElement> cssElements = wait.until(elementsVisibleWithClassName("RY3tic"));

        return cssElements.stream()
                .map(image -> image.getCssValue("background-image"))
                .map(StringTransformer::getURLfromCssValue)
                .collect(Collectors.toList());
    }

    private ExpectedCondition<List<WebElement>> elementsVisibleWithClassName(String className) {
        return ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(className));
    }

    private void initUserAndPasswordFromEnvironmentVariables() {
        googleUser = System.getenv("GOOGLE_USER");
        googlePassword = System.getenv("GOOGLE_PASSWORD");
        if (googleUser == null || googlePassword == null) {
            throw new RuntimeException("Please make sure environment variables GOOGLE_USER and GOOGLE_PASSWORD are set");
        }
    }
}
