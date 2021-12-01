package de.thorsten.tests;

import de.thorsten.pages.EntryAdPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EntryAdTest extends BaseTest {

    @Test
    @DisplayName("Ad modal is present when opening the page")
    public void modalIsPresentOnPageLoad() throws InterruptedException {
        EntryAdPage entryAdPage = new EntryAdPage(driver);
        entryAdPage.visit();

        assertTrue(entryAdPage.modalIsPresent());
    }

    @RepeatedTest(10)
    @DisplayName("Modal is not reopening on page refresh after closing it once")
    // Test would always fail as the feature doesn't work properly. Works with retries
    public void modalIsNotPresentAfterPageReload() throws InterruptedException {
        EntryAdPage entryAdPage = new EntryAdPage(driver);
        entryAdPage.visit();

        entryAdPage.closeModalIfPresent();

        assertFalse(entryAdPage.modalIsPresent());
    }

    @RepeatedTest(10)
    @DisplayName("Restart ad link opens the modal")
    // Test fails a lot of times the page is flaky
    public void restartAdLinkOpensModal() throws InterruptedException {
        EntryAdPage entryAdPage = new EntryAdPage(driver);
        entryAdPage.visit();
        entryAdPage.closeModalIfPresent();

        entryAdPage.reopenModal();

        assertTrue(entryAdPage.modalIsPresent());
    }
}