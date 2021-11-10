package de.thorsten.tests;

import de.thorsten.pages.AddRemoveElementsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    @DisplayName("Button to add a web element works")
    public void addElementButtonWorks() {
        AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage(driver);
        addRemoveElementsPage.visit();

        addRemoveElementsPage.clickAddElementButton();
        assertTrue(addRemoveElementsPage.firstDeleteElementButtonIsDisplayed());

        addRemoveElementsPage.clickAddElementButton();
        assertTrue(addRemoveElementsPage.secondDeleteElementButtonIsDisplayed());

        addRemoveElementsPage.clickAddElementButton();
        assertTrue(addRemoveElementsPage.lastDeleteElementButtonIsDisplayed());
    }

    @Test
    @DisplayName("Button to remove a web element works")
    public void removeElementButtonWorks() {
        AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage(driver);
        addRemoveElementsPage.visit();

        addRemoveElementsPage.createRandomAmountOfDeleteElementButtons();
        int initialNumberOfDeleteElementButtons = addRemoveElementsPage.getNumberOfDeleteElementButtons();

        // Deletes all delete buttons
        for(int i = 0; i < initialNumberOfDeleteElementButtons; i++) {
            addRemoveElementsPage.clickFirstDeleteElementButton();
            int currentNumberOfDeleteElementButtons = addRemoveElementsPage.getNumberOfDeleteElementButtons();

            assertNotEquals(initialNumberOfDeleteElementButtons, currentNumberOfDeleteElementButtons);
        }
        assertTrue(addRemoveElementsPage.noDeleteElementButtonExists());
    }
}