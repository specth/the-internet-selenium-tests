package de.thorsten.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.awt.*;

public class ExitIntentPage extends BasePage {
    public ExitIntentPage(WebDriver driver) {
        super(driver);
        this.subPageUrl = "/exit_intent";
    }

    // Define element selectors
    @FindBy(id = "ouibounce-modal")
    WebElement bounceModal;

    @FindBy(css = ".modal-footer>p")
    WebElement closeModalLink;

    public void moveCursorOutOfViewPane() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        Thread.sleep(1000);
        robot.mouseMove(600,0);
        Thread.sleep(1000);
    }

    public boolean isBounceModalPresent() {
        return bounceModal.isDisplayed();
    }

    public void closeBounceModal() {
        closeModalLink.click();
    }

}
