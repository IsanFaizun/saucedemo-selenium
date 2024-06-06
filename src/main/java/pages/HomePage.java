package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By addBtn = By.id("add-to-cart-sauce-labs-backpack");
    By cartBtn = By.id("shopping_cart_container");
    By textProducts = By.xpath("//*[contains(text(), 'Products')]");

    public void getTextProducts() {
        driver.findElement(textProducts).isDisplayed();
    }

    public String getActualUrl() {
        return driver.getCurrentUrl();
    }

    public void clickAddBtn() {
        driver.findElement(addBtn).click();
    }

    public void clickCartBtn() {
        driver.findElement(cartBtn).click();
    }
}
