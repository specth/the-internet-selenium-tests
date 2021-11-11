package de.thorsten.pages;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlertsPage extends BasePage {

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
        this.subPageUrl = "/javascript_alerts";
    }

    // Define element selectors
    @FindBy(css = "button[onclick='jsAlert()']")
    protected WebElement jsAlertButton;

    @FindBy(css = "button[onclick='jsConfirm()']")
    protected WebElement jsConfirmButton;

    @FindBy(css = "button[onclick='jsPrompt()']")
    protected WebElement jsPromptButton;

    @FindBy(id = "result")
    protected WebElement resultParagraph;

    // Actions
    public void clickJsAlertButton() {
        jsAlertButton.click();
    }

    public void clickJsConfirmButton() {
        jsConfirmButton.click();
    }

    public void clickJsPromptButton() {
        jsPromptButton.click();
    }

    public String getTextOfResultParagraph() {
        return resultParagraph.getText();
    }

    // Assertions
    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException Ex)
        {
            return false;
        }
    }



}