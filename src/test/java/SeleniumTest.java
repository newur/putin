import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by ruwen on 03.10.17.
 */
public class SeleniumTest {

    private final static String GECKO_PATH = "/usr/bin/geckodriver";
    private String googleUser;
    private String googlePassword;

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        initUserAndPasswordFromEnvironmentVariables();
        initWebDriverAndWait();
    }

    @Test
    public void openFirstAlbum() throws Exception {
        driver.navigate().to("https://photos.google.com/albums");

        WebElement identifier = driver.findElement(By.name("identifier"));
        identifier.sendKeys(googleUser);
        identifier.sendKeys(Keys.ENTER);

        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
        password.sendKeys(googlePassword);
        password.sendKeys(Keys.ENTER);

        ExpectedCondition<List<WebElement>> condition =
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("MTmRkb"));
        List<WebElement> albums = wait.until(condition);

        if (albums.size() > 1) {
            albums.get(1).click();
        }
    }

    private void initWebDriverAndWait() {
        System.setProperty("webdriver.gecko.driver", GECKO_PATH);

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
