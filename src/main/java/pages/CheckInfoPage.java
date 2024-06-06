package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckInfoPage {
    WebDriver driver;

    public CheckInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By zipCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By textInfo = By.xpath("//*[contains(text(), 'Checkout: Your Information')]");

    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterZipCode(String zipcode) {
        driver.findElement(zipCode).sendKeys(zipcode);
    }

    public void clickContinueBtn() {
        driver.findElement(continueBtn).click();
    }

    public void getTextInfo() {
        driver.findElement(textInfo).isDisplayed();
    }
}
