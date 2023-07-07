package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductDescriptionPage extends BasePage {
    public ProductDescriptionPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    By continueShoppingButtonLocator = By.id("continue-shopping");
    By backToProductsButtonLocator = By.name("back-to-products");
    By checkoutButtonLocator = By.name("checkout");

    public void clickContinueShoppingButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButtonLocator)).click();
    }

    public void clickBackToProductsButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(backToProductsButtonLocator)).click();
    }

    public void verifyProductDescriptionPage() {
            //verify product description page url
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
    }

    public void clickCheckoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButtonLocator)).click();
    }
}
