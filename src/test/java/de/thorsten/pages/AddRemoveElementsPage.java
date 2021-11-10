package de.thorsten.pages;

import de.thorsten.extensions.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddRemoveElementsPage extends BasePage {

    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
        this.subPageUrl = "/add_remove_elements/";
    }

    // Define element selectors
    @FindBy(css = "button[onclick='addElement()']")
    private WebElement addElementButton;

    @FindBy(css = "#elements>button:first-child")
    private WebElement firstDeleteElementButton;

    @FindBy(css = "#elements>button:nth-child(2)")
    private WebElement secondDeleteElementButton;

    @FindBy(css = "#elements>button:last-child")
    private WebElement lastDeleteElementButton;

    @FindBy(css = "#elements>button")
    private List<WebElement> deleteElementButtons;

    // Actions
    public void clickAddElementButton() { addElementButton.click(); }
    public void clickFirstDeleteElementButton() { firstDeleteElementButton.click(); }
    public int getNumberOfDeleteElementButtons() {
        //return driver.findElements(By.cssSelector("#elements>button")).size();
        return deleteElementButtons.size();
    }

    public void createRandomAmountOfDeleteElementButtons() {
        Helper helper = new Helper();
        int randomNumber = helper.getRandomNumber(1, 3);
        for(int i = 0; i < randomNumber; i++) {
            clickAddElementButton();
        }
    }

    // Assertions
    public boolean firstDeleteElementButtonIsDisplayed() {
        return firstDeleteElementButton.isDisplayed();
    }

    public boolean secondDeleteElementButtonIsDisplayed() {
        return secondDeleteElementButton.isDisplayed();
    }

    public boolean lastDeleteElementButtonIsDisplayed() {
        return lastDeleteElementButton.isDisplayed();
    }

    public boolean noDeleteElementButtonExists() {
        return deleteElementButtons.isEmpty();
    }
}