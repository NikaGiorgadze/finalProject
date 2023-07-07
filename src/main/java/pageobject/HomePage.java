package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ActionDriver;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    By productsLinksLocator = By.xpath("//*[@class='inventory_item_label']/a");
    By addToCartLocator = By.xpath("//*[@class='inventory_details_desc_container']/button");
    By addToCartsLocator = By.xpath("//*[@class='pricebar']/button");
    By productNameLocator = By.xpath("(//*[@class='inventory_details_desc_container']/div)[1]");
    By shoppingCartBadgeLocator = By.xpath("//*[@class='shopping_cart_link']/span");
    By shoppingCartLocator = By.className("shopping_cart_link");
    By titleLocator = By.className("title");
    By filterOptionsLocator = By.tagName("option");
    By burgerMenuButtonLocator = By.id("react-burger-menu-btn");

    public void verifyHomePage() {
        //verify home page url
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    public void selectProductByName(String name) {
        ActionDriver.selectOptionByValue(wait, productsLinksLocator, name);
    }

    public void selectProductByIndex(int index) {
        ActionDriver.selectOptionByIndex(wait, addToCartsLocator, index);
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartLocator)).click();
    }

    public String getSelectedProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productNameLocator)).getText().trim();
    }

    public String getAddToCartButtonColor() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartLocator)).getCssValue("color");
    }

    public boolean shoppingCartBadgeIsDisplayed(int duration) {
        ActionDriver.setImplicitWait(driver, duration);
        boolean shoppingCartBadgeIsDisplayed = driver.findElements(shoppingCartBadgeLocator).size() > 0;
        ActionDriver.setImplicitWait(driver, 0);
        return shoppingCartBadgeIsDisplayed;
    }

    public String getShoppingCartBadgeColor() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartBadgeLocator))
                .getCssValue("background-color").trim();
    }

    public int getShoppingCartBadgeNumber() {
        return Integer.parseInt(wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartBadgeLocator))
                .getText().trim());
    }

    public void clickShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLocator)).click();
    }

    public String getHomePageTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator)).getText().trim();
    }

    public List<Double> getProductsPricesList() {
        List<WebElement> options = wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='inventory_item_price']")));

        List<String> prices = new ArrayList<>();

        for (WebElement option : options) {
            prices.add(option.getText().trim());
        }

        List<Double> doublePrices = new ArrayList<>();

        for (String option : prices) {
            doublePrices.add(Double.parseDouble(option.substring(1)));
        }

        return doublePrices;
    }

    public void clickFilterDropDown() {
        wait.until(ExpectedConditions.elementToBeClickable(By.tagName("select"))).click();
    }

    public void clickFilterOptionByValue(String value) {
        ActionDriver.selectOptionByValue(wait, filterOptionsLocator, value);
    }

    public void clickBurgerMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(burgerMenuButtonLocator)).click();
    }
}
