package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage {
    WebDriver driver;

    public CompletePage(WebDriver driver) {
        this.driver = driver;
    }

    By textComplete = By.xpath("//*[contains(text(), 'Checkout: Complete!')]");

    public void getTextComplete() {
        driver.findElement(textComplete).isDisplayed();
    }
}
