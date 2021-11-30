package de.thorsten.tests;

import de.thorsten.pages.BrokenImagesPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class BrokenImagesTest extends BaseTest {

    @Test
    @DisplayName("Find all images on the page and check if any are broken")
    public void findBrokenImages() throws IOException {
        BrokenImagesPage brokenImagesPage = new BrokenImagesPage(driver);
        brokenImagesPage.visit();

        // test is based on assumption that it's expected to have 2 broken and 2 healthy images
        assertFalse(brokenImagesPage.allImagesAreOkay());
        // those assertions are not really useful but just for the sake of practise
        assertEquals(brokenImagesPage.countBrokenImages(), 2);
        assertEquals(brokenImagesPage.countAllImages(), 4);
        assertEquals(brokenImagesPage.countHealthyImages(), 2);
    }
}
