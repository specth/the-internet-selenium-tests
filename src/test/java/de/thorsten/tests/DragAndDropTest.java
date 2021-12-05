package de.thorsten.tests;

import de.thorsten.pages.DragAndDropPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DragAndDropTest extends BaseTest {

    @Test
    @DisplayName("Switch left and right box")
    public void switchLeftAndRightBox() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.visit();

        String initialValueOfLeftBox = dragAndDropPage.getValueOfLeftBox();

        dragAndDropPage.dragLeftBoxOnRightBox();

        String temporaryValueOfLeftBox = dragAndDropPage.getValueOfLeftBox();

        assertNotEquals(initialValueOfLeftBox, temporaryValueOfLeftBox);
    }
}