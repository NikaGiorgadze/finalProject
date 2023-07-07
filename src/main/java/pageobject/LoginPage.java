package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    By userNameLocator = By.id("user-name");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.id("login-button");
    By errorMessageLocator = By.tagName("h3");
    By errorMessageContainerLocator = By.xpath("(//form/div)[3]");

    public void verifyLoginPage() {
        //verify login page url
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

    public LoginPage setUserName(String userName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameLocator)).sendKeys(userName);
        return this;
    }

    public LoginPage setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator)).sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator)).click();
    }

    public void login(String userName, String password) {
        setUserName(userName)
                .setPassword(password)
                .clickLoginButton();
    }

    public String getUserNameInputColor() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userNameLocator))
                .getCssValue("border-bottom-color");
    }

    public String getPasswordInputColor() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator))
                .getCssValue("border-bottom-color");
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator)).getText().trim();
    }

    public String getErrorMessageColor() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageContainerLocator))
                .getCssValue("background-color");
    }
}
