package de.thorsten.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasicAuthPage extends BasePage {

    public BasicAuthPage(WebDriver driver) {
        super(driver);
        this.subPageUrl = "/basic_auth/";
    }

    // Define element selectors
    @FindBy(css = "h3")
    WebElement headline;

    // Actions
    public void visit(String username, String password) {
        driver.get(protocol + "://" + username + ":" + password + "@" + baseUrl + subPageUrl);
    }

    // Assertions
    public boolean pageAccessed() {
        return headline.isDisplayed();
    }
}