package de.thorsten.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    static String protocol = "http";
    static String baseUrl = "the-internet.herokuapp.com";
    String subPageUrl;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriver driver;
    Alert alert;

    /**
     * Switch to the currently opened Alert to interact with it.
     * @return alert
     */
    private Alert getAlert() {
        return alert = driver.switchTo().alert();
    }

    /**
     * Instantly accept a currently opened Alert without instantiating it explicitly as an object.
     */
    public void acceptAlert() {
        getAlert().accept();
    }

    public void dismissAlert() {
        getAlert().dismiss();
    }

    public void enterPromptText(String text) {
        getAlert().sendKeys(text);
        getAlert().accept();
    }

    public void visit() {
        driver.get(protocol + "://" + baseUrl + subPageUrl);
    }

    public void hover(WebElement webelement) {
        Actions action = new Actions(driver);
        action.moveToElement(webelement).build().perform();
    }
}