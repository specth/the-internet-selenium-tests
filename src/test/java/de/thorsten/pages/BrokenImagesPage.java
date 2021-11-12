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
    protected List<WebElement> listOfImages;

    int amountOfBrokenImages;

    public boolean allImagesAreOkay() throws IOException {
        countBrokenImages();

        return amountOfBrokenImages == 0;
    }
/*

    public int countHealthyImages() {

    }
*/

    public int countAllImages() {
        return listOfImages.size();
    }

    public int countBrokenImages() throws IOException {
        amountOfBrokenImages = 0;
        for (WebElement img : listOfImages)
        {
            if (img != null)
            {
                checkIfImageIsHealthy(img, 200);
            }
        }
        return amountOfBrokenImages;
    }

    public void checkIfImageIsHealthy(WebElement element, int httpCode) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(element.getAttribute("src"));
        HttpResponse response = client.execute(request);
        /* For valid images, the HttpStatus will be 200 */
        if (response.getStatusLine().getStatusCode() != httpCode)
        {
            System.out.println(element.getAttribute("outerHTML") + " is broken.");
            amountOfBrokenImages++;
        }
    }
}
