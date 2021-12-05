package de.thorsten.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {

    public DragAndDropPage(WebDriver driver) {
        super(driver);
        this.subPageUrl = "/drag_and_drop";
    }

    // Selectors
    @FindBy (css = "#column-a header")
    WebElement leftBox;

    @FindBy (css = "#column-b header")
    WebElement rightBox;


    // Actions
    private String getValueOfLeftBox() {
        return leftBox.getText();
    }

    private void dragLeftBoxOnRightBox() {


    }
}
