package de.thorsten.tests;

import de.thorsten.pages.JavaScriptAlertsPage;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class JavaScriptAlertsTest extends BaseTest {

    @Test
    @DisplayName("Open JavaScript alert works")
    public void openJavaScriptAlert() {
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        javaScriptAlertsPage.visit();

        javaScriptAlertsPage.clickJsAlertButton();

        assertTrue(javaScriptAlertsPage.alertIsPresent());
    }

    @Test
    @DisplayName("Confirm JavaScript alert works")
    public void confirmJavaScriptAlert() {
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        javaScriptAlertsPage.visit();
        javaScriptAlertsPage.clickJsAlertButton();

        javaScriptAlertsPage.acceptAlert();

        assertFalse(javaScriptAlertsPage.alertIsPresent(), "Alert is not present");
        assertEquals(javaScriptAlertsPage.getTextOfResultParagraph(), "You successfully clicked an alert");
    }

    @Test
    @DisplayName("Dismiss JavaScript alert works")
    public void dismissJavaScriptAlert() {
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        javaScriptAlertsPage.visit();
        javaScriptAlertsPage.clickJsConfirmButton();

        javaScriptAlertsPage.dismissAlert();

        assertFalse(javaScriptAlertsPage.alertIsPresent(), "Alert is not present");
        assertEquals(javaScriptAlertsPage.getTextOfResultParagraph(), "You clicked: Cancel");
    }

    @Test
    @DisplayName("Dismiss JavaScript prompt works")
    public void openJavaScriptPrompt() {
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        javaScriptAlertsPage.visit();

        javaScriptAlertsPage.clickJsPromptButton();
        assertTrue(javaScriptAlertsPage.alertIsPresent());

        javaScriptAlertsPage.dismissAlert();
        assertEquals(javaScriptAlertsPage.getTextOfResultParagraph(), "You entered: null");
    }

    @Test
    @DisplayName("Enter text in JavaScript prompt works")
    public void enterTextInJavaScriptPrompt() {
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        javaScriptAlertsPage.visit();
        javaScriptAlertsPage.clickJsPromptButton();

        javaScriptAlertsPage.enterPromptText("This is a prompt");

        assertFalse(javaScriptAlertsPage.alertIsPresent());
        assertEquals(javaScriptAlertsPage.getTextOfResultParagraph(), "You entered: This is a prompt");
    }
}