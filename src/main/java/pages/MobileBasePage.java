package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.Arrays;

public class MobileBasePage {
    protected AppiumDriver driver;
    protected Actions actions;

    public MobileBasePage(AppiumDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    FluentWait<AppiumDriver> wait = new FluentWait<AppiumDriver>(driver);

    protected void fluentWaitForElement(WebElement webElement) {
//        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void scrollToElement(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void FillTextBox(WebElement webElement, String text) {
        wait.until(ExpectedConditions.visibilityOf(webElement)).sendKeys(text);

    }

    public void clickOn(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement)).click();
    }

    public boolean isDisplayed(WebElement webElement) {
        boolean status;
        if (wait.until(ExpectedConditions.visibilityOf(webElement)).isDisplayed()) {
            status = true;
        } else {
            status = false;
        }
        return status;
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (NoSuchElementException e) {
            // Log that the element was not found
            System.out.println("Element not found: " + e.getMessage());
            return false;
        }
    }

    public void swipeLeft() {
        // Get the screen size
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.9); // Start very close to the right edge
        int endX = (int) (size.width * 0.1); // End very close to the left edge
        int startY = (int) (size.height * 0.8); // Middle of the screen vertically
        // Perform swipe


        TouchAction<?> action = new TouchAction<>((io.appium.java_client.android.AndroidDriver) driver);
        WaitOptions wait = new WaitOptions().withDuration(Duration.ofMillis(1));
        action.press(PointOption.point(startX, startY))
                .waitAction(wait).
                moveTo(PointOption.point(endX, startY))
                .release().perform();
    }


}

