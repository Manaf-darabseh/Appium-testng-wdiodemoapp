package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class PageFactory {
    private final AppiumDriver driver;

    public PageFactory(AndroidDriver driver) {
        this.driver = driver;
    }

    public wdiodemoAppHomePage wdiodemoAppHomePage() {
        return new wdiodemoAppHomePage(driver);
    }

    public wdiodemoAppSingUP wdiodemoAppSingUP() {
        return new wdiodemoAppSingUP(driver);
    }

    public wdiodemoAppSwipePage wdiodemoAppSwipePage() {
        return new wdiodemoAppSwipePage(driver);
    }

    public wdiodemoAppFormPage wdiodemoAppFormPage() {  return new wdiodemoAppFormPage(driver);
    }
}