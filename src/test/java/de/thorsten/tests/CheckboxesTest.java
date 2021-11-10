package de.thorsten.tests;

import de.thorsten.pages.CheckboxesPage;
import de.thorsten.pages.JavaScriptAlertsPage;
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
        assertTrue(checkboxesPage.isFirstCheckboxSelected());

        checkboxesPage.deselectFirstCheckbox();
        assertFalse(checkboxesPage.isFirstCheckboxSelected());

        checkboxesPage.selectSecondCheckbox();
        assertTrue(checkboxesPage.isSecondCheckboxSelected());

        checkboxesPage.deselectSecondCheckbox();
        assertFalse(checkboxesPage.isSecondCheckboxSelected());
    }
}