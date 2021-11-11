package de.thorsten.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxesPage extends BasePage {

    public CheckboxesPage(WebDriver driver) {
        super(driver);
        this.subPageUrl = "/checkboxes";
    }

    // Define element selectors
    @FindBy(xpath = "//*[@id='checkboxes']/input[1]")
    protected WebElement firstCheckbox;

    @FindBy(xpath = "//*[@id='checkboxes']/input[2]")
    protected WebElement secondCheckbox;

    // Actions
    public void selectFirstCheckbox() {
        if (!firstCheckbox.isSelected()) {
            firstCheckbox.click();
        }
    }

    public void selectSecondCheckbox() {
        if (!secondCheckbox.isSelected()) {
            secondCheckbox.click();
            System.out.println("Second checkbox has been clicked");
        } else {
            System.out.println("Second checkbox has not been clicked");
        }
    }

    public void deselectFirstCheckbox() {
        if (firstCheckbox.isSelected()) {
            firstCheckbox.click();
        }
    }

    public void deselectSecondCheckbox() {
        if (secondCheckbox.isSelected()) {
            secondCheckbox.click();
        }
    }

    // Assertions
    public boolean isFirstCheckboxSelected() {
        return firstCheckbox.isSelected();
    }

    public boolean isSecondCheckboxSelected() {
        return secondCheckbox.isSelected();
    }
}

