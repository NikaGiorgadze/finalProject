package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    By userNameLocator = By.id("first-name");
    By lastNameLocator = By.id("last-name");
    By postalCodeLocator = By.id("postal-code");
    By errorTextLocator = By.tagName("h3");
    By continueButtonLocator = By.id("continue");

    public void verifyCheckoutPage() {
        //verify checkout page url
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
    }

    public CheckoutPage setUserName(String userName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameLocator)).sendKeys(userName);
        return this;
    }

    public CheckoutPage setLastName(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameLocator)).sendKeys(password);
        return this;
    }

    public void setPostalCode(String postalCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeLocator)).sendKeys(postalCode);
    }

    public void setData(String username, String lastName, String postalCode) {
        setUserName(username)
                .setLastName(lastName)
                .setPostalCode(postalCode);
    }

    public String getErrorText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorTextLocator)).getText().trim();
    }

    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButtonLocator)).click();
    }
}
