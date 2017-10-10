import com.putin.utils.GeckoDriverFinder;
import com.putin.utils.StringTransformer;
import org.junit.Before;
import org.junit.Ignore;
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
import java.util.stream.Collectors;

/**
 * Created by ruwen on 03.10.17.
 */
public class SeleniumTest {

    private String googleUser;
    private String googlePassword;

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", GeckoDriverFinder.findGeckoDriverForOS());
        initUserAndPasswordFromEnvironmentVariables();
        initWebDriverAndWait();
    }

    @Test
    public void openFirstAlbum() throws Exception {
        driver.navigate().to("https://photos.googlecalendar.com/albums");

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

        condition = ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("RY3tic"));
        List<WebElement> cssElements = wait.until(condition);

        List<String> imageUrls = cssElements.stream()
                .map(image -> image.getCssValue("background-image"))
                .map(StringTransformer::getURLfromCssValue)
                .collect(Collectors.toList());

        imageUrls.forEach(System.out::println);
    }

    @Test
    public void openGoogle() {
        driver.navigate().to("https://googlecalendar.com");
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
