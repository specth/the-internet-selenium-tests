package de.thorsten.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HoversPage extends BasePage {

    public HoversPage(WebDriver driver) {
        super(driver);
        this.subPageUrl = "/hovers";
    }

    // Selectors
    @FindBy (xpath = "//div[@class='example']//div[1]//img[1]")
    WebElement user1Image;

    @FindBy (xpath = "//h5[normalize-space()='name: user1']")
    WebElement user1Name;

    @FindBy (xpath = "//div[@class='example']//div[2]//img[1]")
    WebElement user2Image;

    @FindBy (xpath = "//h5[normalize-space()='name: user2']")
    WebElement user2Name;

    @FindBy (xpath = "//div[@class='example']//div[3]//img[1]")
    WebElement user3Image;

    @FindBy (xpath = "//h5[normalize-space()='name: user3']")
    WebElement user3Name;

    // Actions
    public void hoverAboveImageOfUserX(int user) {
        Actions action = new Actions(driver);

        switch (user) {
            case 1:
                // Alternative hover method implemented in Base Page
                hover(user1Image);
                break;
            case 2:
                action.moveToElement(user2Image);
                break;
            case 3:
                action.moveToElement(user3Image);
                break;
        }
    }

    // Checks
    public boolean username1IsDisplayed() {
        return user1Name.isDisplayed();
    }

    public boolean username2IsDisplayed() {
        return user2Name.isDisplayed();
    }

    public boolean username3IsDisplayed() {
        return user3Name.isDisplayed();
    }


}
