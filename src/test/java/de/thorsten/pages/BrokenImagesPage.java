package de.thorsten.pages;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;
import java.util.List;

public class BrokenImagesPage extends BasePage {

    public BrokenImagesPage(WebDriver driver) {
        super(driver);
        this.subPageUrl = "/broken_images";
    }

    // Define element selectors
    @FindBy(tagName = "img")
    List<WebElement> listOfImages;

    // Define metrics for test methods
    int amountOfBrokenImages;
    int amountOfHealthyImages;

    // Checks
    public boolean allImagesAreOkay() throws IOException {
        countBrokenImages();
        return amountOfBrokenImages == 0;
    }

    // Helper
    public int countAllImages() {
        return listOfImages.size();
    }

    public int countHealthyImages() throws IOException {
        amountOfHealthyImages = 0;
        for (WebElement img : listOfImages)
        {
            if (img != null)
            {
                checkIfImageIsHealthy(img);
            }
        }
        return amountOfHealthyImages;
    }

    public int countBrokenImages() throws IOException {
        amountOfBrokenImages = 0;
        for (WebElement img : listOfImages)
        {
            if (img != null)
            {
                checkIfImageIsHealthy(img);
            }
        }
        return amountOfBrokenImages;
    }

    private void checkIfImageIsHealthy(WebElement element) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(element.getAttribute("src"));
        HttpResponse response = client.execute(request);

        /* For valid images, the HttpStatus will be 200 */
        if (response.getStatusLine().getStatusCode() == 200)
        {
            System.out.println(element.getAttribute("outerHTML") + " is okay.");
            amountOfHealthyImages++;
        } else {
            System.out.println(element.getAttribute("outerHTML") + " is broken.");
            amountOfBrokenImages++;
        }
    }
}
