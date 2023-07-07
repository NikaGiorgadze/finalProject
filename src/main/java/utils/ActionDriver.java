package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ActionDriver {
    public void staticWaitMillis(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void staticWaitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setImplicitWait(WebDriver driver, int implicitDuration) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitDuration));
    }

    public static void selectOptionByValue(WebDriverWait wait, By optionsLocator, String value) {
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(optionsLocator));

        for (WebElement option : options) {
            if (option.getText().trim().equals(value)) {
                option.click();
                break;
            }
        }
    }

    public static void selectOptionByIndex(WebDriverWait wait, By optionsLocator, int index) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(optionsLocator)).get(index - 1).click();
    }
}
