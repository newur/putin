package com.putin.integration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GoogleCalenderITest extends AbstractSeleniumTest {

    @LocalServerPort
    private int port;

    public String host;

    @Before
    public void setUp() {
        host = "http://localhost:" + port + "/";
    }

    @Test
    public void openUserSettingWithFirefox() throws Exception {
        driver.navigate().to(host + "settings.html");
        WebElement contactInput = wait.until(elementToBeClickable(By.xpath("//td[contains(text(), 'Contacts')]/../td/input[1]")));

        boolean isSelectedBeforeClick = contactInput.isSelected();
        contactInput.click();
        assertTrue(contactInput.isSelected() == !isSelectedBeforeClick);
    }

}
