package de.thorsten.tests;

import de.thorsten.pages.NestedFramesPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FramesTests extends BaseTest {

    @Test
    @DisplayName("Page displays the correct text")
    public void correctTextIsDisplayed() {
        NestedFramesPage nestedFramesPage = new NestedFramesPage(driver);
        nestedFramesPage.visit();
    }
}