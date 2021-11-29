package de.thorsten.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EntryAdPage extends BasePage {

    public EntryAdPage(WebDriver driver) {
        super(driver);
        this.subPageUrl = "/entry_ad";
    }

    // Selectors
    @FindBy (id = "restart-ad")
    WebElement restartAdModal;

    @FindBy (css = ".modal-footer>p")
    WebElement closeModalButton;

    @FindBy (className = "modal")
    WebElement modalContainer;

    // Actions
    public void closeModal() {
        closeModalButton.click();
    }

    public void reopenModal() {
        restartAdModal.click();
    }

    public void closeModalIfPresent() {
        if(modalIsPresent()) {
            closeModalButton.click();
        }
    }

    public void waitForModalToBePresent() {
        // TODO: implement
    }

    // Checks
    public boolean modalIsPresent() {
        return modalContainer.isDisplayed();
    }
}
