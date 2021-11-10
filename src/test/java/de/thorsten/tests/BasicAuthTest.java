package de.thorsten.tests;

import de.thorsten.pages.BasicAuthPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasicAuthTest extends BaseTest {

    @Test
    @DisplayName("Button to add a web element works")
    public void sendingBasicAuthInformationWorks() {
        BasicAuthPage basicAuthPage = new BasicAuthPage(driver);
        basicAuthPage.visit("admin", "admin");

        assertTrue(basicAuthPage.pageAccessed());
    }
}