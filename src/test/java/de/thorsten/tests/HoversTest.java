package de.thorsten.tests;

import de.thorsten.pages.HoversPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HoversTest extends BaseTest {

    @Test
    @DisplayName("Username appears when hovering above the image")
    // TODO: Assertions currently fail. FIX!
    public void correctTextIsDisplayed() {
        HoversPage hoversPage = new HoversPage(driver);
        hoversPage.visit();

        assertFalse(hoversPage.username1IsDisplayed());
        hoversPage.hoverAboveImageOfUserX(1);
        assertTrue(hoversPage.username1IsDisplayed());

        assertFalse(hoversPage.username2IsDisplayed());
        hoversPage.hoverAboveImageOfUserX(2);
        assertTrue(hoversPage.username2IsDisplayed());

        assertFalse(hoversPage.username3IsDisplayed());
        hoversPage.hoverAboveImageOfUserX(3);
        assertTrue(hoversPage.username3IsDisplayed());
    }
}