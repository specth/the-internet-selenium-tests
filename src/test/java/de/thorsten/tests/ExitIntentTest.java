package de.thorsten.tests;

import de.thorsten.pages.ExitIntentPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExitIntentTest extends BaseTest {
    @Test
    @DisplayName("Modal opens when mouse leaves viewport")
    public void openExitIntentModal() throws InterruptedException, AWTException {
        ExitIntentPage exitIntentPage = new ExitIntentPage(driver);
        exitIntentPage.visit();

        exitIntentPage.moveCursorOutOfViewPane();
        assertTrue(exitIntentPage.isBounceModalPresent());

        exitIntentPage.closeBounceModal();
        assertFalse(exitIntentPage.isBounceModalPresent());
    }
}
