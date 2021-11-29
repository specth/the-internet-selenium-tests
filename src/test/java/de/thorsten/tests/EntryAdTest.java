package de.thorsten.tests;

import de.thorsten.pages.EntryAdPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EntryAdTest extends BaseTest {

    @Test
    @DisplayName("Ad modal is present when opening the page")
    public void modalIsPresentOnPageLoad() {
        EntryAdPage entryAdPage = new EntryAdPage(driver);
        entryAdPage.visit();




        assertTrue(entryAdPage.modalIsPresent());
    }

    @Test
    @DisplayName("Modal is not reopening on page refresh after closing it once")
    public void modalIsNotPresentAfterPageReload() {
        EntryAdPage entryAdPage = new EntryAdPage(driver);
        entryAdPage.visit();

        entryAdPage.closeModalIfPresent();
        entryAdPage.refresh();

        assertFalse(entryAdPage.modalIsPresent());
    }

    @Test
    @DisplayName("Restart ad link opens the modal")
    public void restartAdLinkOpensModal() {
        EntryAdPage entryAdPage = new EntryAdPage(driver);
        entryAdPage.visit();
        entryAdPage.closeModalIfPresent();

        entryAdPage.reopenModal();

        assertTrue(entryAdPage.modalIsPresent());
    }
}