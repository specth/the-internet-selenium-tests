package de.thorsten.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TyposPage extends BasePage {

    public TyposPage(WebDriver driver) {
        super(driver);
        this.subPageUrl = "/typos";
    }

    // Define content to be checked
    private static String textOfSecondParagraph = "Sometimes you'll see a typo, other times you won't.";

    // Define element selectors
    @FindBy (css = ".example>p:last-child")
    WebElement paragraph;

    // Checks
    public boolean textOfSecondParagraphIsCorrect() {
        String actualTextOfSecondParagraph = paragraph.getText();
        System.out.println("Expected text of paragraph: " + textOfSecondParagraph);
        System.out.println("Actual text of paragraph: " + actualTextOfSecondParagraph);
        return actualTextOfSecondParagraph.equals(textOfSecondParagraph);
    }
}
