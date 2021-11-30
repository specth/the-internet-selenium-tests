package de.thorsten.tests;

import de.thorsten.pages.CheckboxesPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckboxesTest extends BaseTest {

    @Test
    @DisplayName("Selecting a checkbox works")
    public void selectCheckboxWorks() {
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        checkboxesPage.visit();
        checkboxesPage.selectFirstCheckbox();
        assertTrue(checkboxesPage.firstCheckboxIsSelected());

        checkboxesPage.selectSecondCheckbox();
        assertTrue(checkboxesPage.secondCheckboxIsSelected());
    }

    @Test
    @DisplayName("Deselecting a checkbox works")
    public void deselectCheckboxWorks() {
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        checkboxesPage.visit();

        checkboxesPage.deselectFirstCheckbox();
        assertFalse(checkboxesPage.firstCheckboxIsSelected());

        checkboxesPage.deselectSecondCheckbox();
        assertFalse(checkboxesPage.secondCheckboxIsSelected());
    }
}