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
    public void reopenModal() throws InterruptedException {
        for(int i = 0; i < 5; i++) {
            if (!modalIsPresent()) {
                restartAdModal.click();
            } else {
                break;
            }
        }
    }

    public void closeModalIfPresent() throws InterruptedException {
        if(modalIsPresent()) {
            closeModalButton.click();
        }
    }

    public void waitForModalToBePresent() {
        // TODO: implement
    }

    // Checks
    public boolean modalIsPresent() throws InterruptedException {
        // TODO: replace by explicit wait => waitForModalToBePresent()
        Thread.sleep(1500);
        return modalContainer.isDisplayed();
    }
}
