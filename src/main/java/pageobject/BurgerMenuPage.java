package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ActionDriver;

public class BurgerMenuPage extends BasePage {
    public BurgerMenuPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    By burgerMenuLinksLocator = By.cssSelector("nav > a");

    public void selectBurgerMenuOptionByValue(String value) {
        ActionDriver.selectOptionByValue(wait, burgerMenuLinksLocator, value);
    }
}
