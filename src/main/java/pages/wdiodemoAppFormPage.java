package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class wdiodemoAppFormPage extends MobileBasePage {


    @FindBy(xpath = "//android.widget.EditText[@content-desc='text-input']")
    WebElement textInput;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='input-text-result']")
    WebElement textInputResult;

    @FindBy(xpath = "//android.widget.Switch[@content-desc='switch']")
    WebElement FormsSwitch;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Dropdown']")
    WebElement Dropdown;
    @FindBy(xpath = "//android.widget.CheckedTextView[@text='webdriver.io is awesome']")
    WebElement DropdownItem;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='button-Active']")
    WebElement ActiveButton;

    @FindBy(xpath = "//android.widget.Button[@text='OK']")
    WebElement okButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='button-Inactive']")
    WebElement InactiveButton;



    public wdiodemoAppFormPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void InputText(String Email){
        fluentWaitForElement(textInput);
        FillTextBox(textInput , Email);
    }

    public boolean textInputResultIsDisplayed() {
        return textInputResult.isDisplayed();
    }

    public void clickswitchButton() {
        fluentWaitForElement(FormsSwitch);
        clickOn(FormsSwitch);
    }

    public void clickDDlist() {
        fluentWaitForElement(Dropdown);
        clickOn(Dropdown);
        clickOn(DropdownItem);
    }

    public boolean InactiveButtonIsDisplayed() {
        fluentWaitForElement(InactiveButton);
        return isDisplayed(InactiveButton);
    }

    public void clickactiveButton() {
        fluentWaitForElement(ActiveButton);
        clickOn(ActiveButton);
        clickOn(okButton);
    }


}

