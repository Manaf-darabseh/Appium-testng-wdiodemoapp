package test;

import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class wdiodemoAppForm extends MobileTestBase {


    @Test(priority=1)
    public void verifyFormsTapDisplayed(){


        Assert.assertTrue(page.wdiodemoAppHomePage().FormsTap_isDisplayed());

    }


    @Test(dependsOnMethods = "verifyFormsTapDisplayed")
    public void verifyClickonFormsTab(){

        page.wdiodemoAppHomePage().clickForms();
    }

    @Test(dependsOnMethods = "verifyClickonFormsTab")
    public void verifyFormsTabElement(){
        page.wdiodemoAppFormPage().InputText(System.getProperty("Email"));
        page.wdiodemoAppFormPage().clickswitchButton();
        page.wdiodemoAppFormPage().clickDDlist();
        page.wdiodemoAppFormPage().clickactiveButton();
        Assert.assertTrue(page.wdiodemoAppFormPage().InactiveButtonIsDisplayed());
        Assert.assertTrue(page.wdiodemoAppFormPage().textInputResultIsDisplayed());

    }

}
