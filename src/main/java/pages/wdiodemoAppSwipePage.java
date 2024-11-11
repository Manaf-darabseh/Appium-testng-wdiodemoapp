package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;


public class wdiodemoAppSwipePage extends MobileBasePage {


    @FindBy(xpath = "//android.widget.TextView[@text='SUPPORT VIDEOS')]")
    private WebElement supportVideosCard;



    public wdiodemoAppSwipePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void swipeToSupportVideos() {
        int swipeAttempts = 0;
        while (!isElementDisplayed(supportVideosCard) && swipeAttempts < 10) {
            swipeLeft();
            swipeAttempts++;
        }
    }
    public boolean supportVideosCard_isDisplayed(){
        return isDisplayed(supportVideosCard);
    }

}

