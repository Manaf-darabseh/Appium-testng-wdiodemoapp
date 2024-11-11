package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class wdiodemoAppSingUP extends MobileBasePage {


    @FindBy(xpath = "//android.widget.EditText[@content-desc='input-email']")
    WebElement Email_SignUP;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='input-password']")
    WebElement password_SignUP;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='input-repeat-password']")
    WebElement passwordRepeat_SignUP;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='button-SIGN UP']")
    WebElement button_SignUP;

    @FindBy(id = "android:id/message")
    WebElement successMessage;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='button-LOGIN']")
    WebElement LoginButton;


    public wdiodemoAppSingUP(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


       public void clickSignUP() {
        fluentWaitForElement(button_SignUP);
           clickOn(button_SignUP);
    }
    public void SignUPIsDisplayed() {
        fluentWaitForElement(button_SignUP);
        Assert.assertTrue(button_SignUP.isDisplayed());
    }

    public void FillEmailTextBox(String Email){
        fluentWaitForElement(Email_SignUP);
        FillTextBox(Email_SignUP , Email);
    }
    public void FillPassword_SignUP(String Password){
        fluentWaitForElement(password_SignUP);
        FillTextBox(password_SignUP , Password);
    }
    public void FillpasswordRepeat_SignUP(String Password){
        fluentWaitForElement(passwordRepeat_SignUP);
        FillTextBox(passwordRepeat_SignUP , Password);
    }    public void signUp_successMessage_displayed(){
        fluentWaitForElement(successMessage);
    }
    public void clickLoginButton() {
        fluentWaitForElement(LoginButton);
        clickOn(LoginButton);
    }
}