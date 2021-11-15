package de.thorsten.tests;

import de.thorsten.pages.HoversPage;
import de.thorsten.pages.TyposPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HoversTest extends BaseTest {

    @Test
    @DisplayName("Username appears when hovering above the image")
    public void correctTextIsDisplayed() {
        HoversPage hoversPages = new HoversPage(driver);
        hoversPages.visit();
    }
}