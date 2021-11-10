package de.thorsten.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import de.thorsten.extensions.Helper;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;
    protected static Helper helper = new Helper();

    @BeforeEach
     public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }
}