import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class SauceTest {
    public WebDriver driver;
    public String url = "https://www.saucedemo.com";
    String urlInventory = "https://www.saucedemo.com/inventory.html";
    String urlCart = "https://www.saucedemo.com/cart.html";
    String urlInfo = "https://www.saucedemo.com/checkout-step-one.html";
    String urlOverview = "https://www.saucedemo.com/checkout-step-two.html";
    String urlComplete = "https://www.saucedemo.com/checkout-complete.html";


    @BeforeEach
    public void setup(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void testCheckout(){
        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        CheckInfoPage checkInfo = new CheckInfoPage(driver);
        OverviewPage overview = new OverviewPage(driver);
        CompletePage complete = new CompletePage(driver);

        // Login to Home
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();
        String actualUrl1 = driver.getCurrentUrl();
        Assertions.assertEquals(actualUrl1, urlInventory);
        home.getTextProducts();

        // Home to Cart
        home.clickAddBtn();
        home.clickCartBtn();
        String actualUrl2 = driver.getCurrentUrl();
        Assertions.assertEquals(actualUrl2, urlCart);
        cart.getTextCart();

        // Cart to CheckInfo
        cart.clickCheckoutBtn();
        String actualUrl3 = driver.getCurrentUrl();
        Assertions.assertEquals(actualUrl3, urlInfo);
        checkInfo.getTextInfo();

        // CheckInfo to Overview
        checkInfo.enterFirstName("standard");
        checkInfo.enterLastName("user");
        checkInfo.enterZipCode("123456");
        checkInfo.clickContinueBtn();
        String actualUrl4 = driver.getCurrentUrl();
        Assertions.assertEquals(actualUrl4, urlOverview);
        overview.getTextOverview();

        // Overview to Complete
        overview.clickFinishBtn();
        String actualUrl5 = driver.getCurrentUrl();
        Assertions.assertEquals(actualUrl5, urlComplete);
        complete.getTextComplete();
    }

    @AfterEach
    public void terminate(){
        driver.quit();
    }
}
