package de.thorsten.tests;

import de.thorsten.pages.TyposPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TyposTest extends BaseTest {

    @Test
    @DisplayName("Page displays the correct text")
    public void correctTextIsDisplayed() {
        TyposPage tyopsPage = new TyposPage(driver);
        tyopsPage.visit();
    }
}