package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By checkoutBtn = By.id("checkout");
    By textCart = By.xpath("//*[contains(text(), 'Your Cart')]");

    public void getTextCart() {
        driver.findElement(textCart).isDisplayed();
    }
    public void clickCheckoutBtn() {
        driver.findElement(checkoutBtn).click();
    }
}
