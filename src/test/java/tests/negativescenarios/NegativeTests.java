package tests.negativescenarios;

import dataobject.CheckoutData;
import dataobject.LoginData;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.CheckoutPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.ProductDescriptionPage;
import utils.Runner;

public class NegativeTests extends Runner {
    @Test(priority = 1, invocationCount = 1, enabled = true, testName = "ვწერთ მხოლოდ იუზერნეიმს")
    @Description("ვწერთ მხოლოდ იუზერნეიმს")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://www.saucedemo.com/")
    public void setOnlyUserName() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("abc", "");
        //verify that after set only userName, both userName and password input must be red and
        // red error h3 element must be displayed with proper text
        Assert.assertEquals(loginPage.getUserNameInputColor(), "rgba(226, 35, 26, 1)");
        Assert.assertEquals(loginPage.getPasswordInputColor(), "rgba(226, 35, 26, 1)");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
        Assert.assertEquals(loginPage.getErrorMessageColor(), "rgba(226, 35, 26, 1)");
    }

    @Test(priority = 2, invocationCount = 1, enabled = true, testName = "ვწერთ მხოლოდ პასვორდს")
    @Description("ვწერთ მხოლოდ პასვორდს")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://www.saucedemo.com/")
    public void setOnlyPassword() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("", "123");
        //verify that after set only userName, both userName and password input must be red and
        // red error h3 element must be displayed with proper text
        Assert.assertEquals(loginPage.getUserNameInputColor(), "rgba(226, 35, 26, 1)");
        Assert.assertEquals(loginPage.getPasswordInputColor(), "rgba(226, 35, 26, 1)");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
        Assert.assertEquals(loginPage.getErrorMessageColor(), "rgba(226, 35, 26, 1)");
    }

    @Test(priority = 3, invocationCount = 1, enabled = true, testName = "ვწერთ არასწორ იუზერნეიმს ან პასვორდს")
    @Description("ვწერთ არასწორ იუზერნეიმს ან პასვორდს")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://www.saucedemo.com/")
    public void setIncorrectPasswordOrUserName() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("standard_user", "123");
        loginPage.clickLoginButton();
        //verify that after set only userName both userName and password input must be red and
        // red error h3 element must be displayed
        Assert.assertEquals(loginPage.getUserNameInputColor(), "rgba(226, 35, 26, 1)");
        Assert.assertEquals(loginPage.getPasswordInputColor(), "rgba(226, 35, 26, 1)");
        Assert.assertEquals(loginPage.getErrorMessage()
                , "Epic sadface: Username and password do not match any user in this service");
        Assert.assertEquals(loginPage.getErrorMessageColor(), "rgba(226, 35, 26, 1)");
    }

    @Test(priority = 4, invocationCount = 1, enabled = true, testName = "Checkout გვერდზე არ ვავსებთ სახელის ველს")
    @Description("Checkout გვერდზე არ ვავსებთ სახელის ველს")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://www.saucedemo.com/")
    public void missingFirstNameOnCheckoutPage() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.verifyLoginPage();
        loginPage.login(LoginData.userName, LoginData.password);

        HomePage homePage = new HomePage(driver, wait);
        homePage.verifyHomePage();
        homePage.selectProductByIndex(3);
        homePage.clickShoppingCart();

        ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage(driver, wait);
        productDescriptionPage.verifyProductDescriptionPage();
        productDescriptionPage.clickCheckoutButton();

        CheckoutPage checkoutPage = new CheckoutPage(driver, wait);
        checkoutPage.verifyCheckoutPage();
        checkoutPage.setData("", "", "");
        checkoutPage.clickContinueButton();
        //when not setting firstName There should appear proper error text
        Assert.assertEquals(checkoutPage.getErrorText(), "Error: First Name is required");
    }

    @Test(priority = 5, invocationCount = 1, enabled = true, testName = "Checkout გვერდზე არ ვავსებთ გვარის ველს")
    @Description("Checkout გვერდზე არ ვავსებთ გვარის ველს")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://www.saucedemo.com/")
    public void missingLastnameOnCheckoutPage() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.verifyLoginPage();
        loginPage.login(LoginData.userName, LoginData.password);

        HomePage homePage = new HomePage(driver, wait);
        homePage.verifyHomePage();
        homePage.selectProductByIndex(3);
        homePage.clickShoppingCart();

        ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage(driver, wait);
        productDescriptionPage.verifyProductDescriptionPage();
        productDescriptionPage.clickCheckoutButton();

        CheckoutPage checkoutPage = new CheckoutPage(driver, wait);
        checkoutPage.verifyCheckoutPage();
        checkoutPage.setData(CheckoutData.firstName, "", "");
        checkoutPage.clickContinueButton();
        //when not setting lastName There should appear proper error text
        Assert.assertEquals(checkoutPage.getErrorText(), "Error: Last Name is required");
    }

    @Test(priority = 6, invocationCount = 1, enabled = true, testName = "Checkout გვერდზე არ ვავსებთ საფოსტო კოდის ველს")
    @Description("Checkout გვერდზე არ ვავსებთ საფოსტო კოდს ველს")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://www.saucedemo.com/")
    public void missingPostalCodeOnCheckoutPage() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.verifyLoginPage();
        loginPage.login(LoginData.userName, LoginData.password);

        HomePage homePage = new HomePage(driver, wait);
        homePage.verifyHomePage();
        homePage.selectProductByIndex(3);
        homePage.clickShoppingCart();

        ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage(driver, wait);
        productDescriptionPage.verifyProductDescriptionPage();
        productDescriptionPage.clickCheckoutButton();

        CheckoutPage checkoutPage = new CheckoutPage(driver, wait);
        checkoutPage.verifyCheckoutPage();
        checkoutPage.setData(CheckoutData.firstName, CheckoutData.lastName, "");
        checkoutPage.clickContinueButton();
        //when not setting firstName There should appear proper error text
        Assert.assertEquals(checkoutPage.getErrorText(), "Error: Postal Code is required");
    }
}
