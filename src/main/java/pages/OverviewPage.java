package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {
    WebDriver driver;

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    By finishBtn = By.id("finish");
    By textOverview = By.xpath("//*[contains(text(), 'Checkout: Overview')]");

    public void getTextOverview() {
        driver.findElement(textOverview).isDisplayed();
    }
    public void clickFinishBtn() {
        driver.findElement(finishBtn).click();
    }
}
