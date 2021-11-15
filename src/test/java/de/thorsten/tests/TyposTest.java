package de.thorsten.tests;

import de.thorsten.pages.TyposPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TyposTest extends BaseTest {

    @Test
    @RepeatedTest(2)
    @DisplayName("Page displays the correct text")
    public void correctTextIsDisplayed() {
        TyposPage typosPage = new TyposPage(driver);
        typosPage.visit();

        assertTrue(typosPage.textOfSecondParagraphIsCorrect());
    }
}