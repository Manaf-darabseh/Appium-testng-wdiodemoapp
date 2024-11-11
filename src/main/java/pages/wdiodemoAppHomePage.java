package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.openqa.selenium.support.PageFactory;


public class wdiodemoAppHomePage extends MobileBasePage {

    @FindBy(xpath = "//android.view.View[@content-desc='Login']")
    WebElement LoginTap;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='button-sign-up-container']")
    WebElement signUpTap;

    @FindBy(xpath = "//android.view.View[@content-desc='Swipe']")
    WebElement SwipeTab;

    @FindBy(xpath = "//android.view.View[@content-desc='Forms']")
    WebElement FormsTap;


    public wdiodemoAppHomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


       public void clickLoginTap() {
        fluentWaitForElement(LoginTap);
        LoginTap.click();
    }
    public void LoginButtonIsDisplayed() {
        fluentWaitForElement(LoginTap);
        Assert.assertTrue(LoginTap.isDisplayed());
    }

    public void clickSignUp() {
        fluentWaitForElement(signUpTap);
        clickOn(signUpTap);
    }

    public boolean SwipTap_isDisplayed(){
        return isDisplayed(SwipeTab);
    }
    public boolean FormsTap_isDisplayed(){
        return isDisplayed(FormsTap);
    }

    public void clickSwipe() {
        fluentWaitForElement(SwipeTab);
        clickOn(SwipeTab);
    }    public void clickForms() {
        fluentWaitForElement(FormsTap);
        clickOn(FormsTap);
    }
}