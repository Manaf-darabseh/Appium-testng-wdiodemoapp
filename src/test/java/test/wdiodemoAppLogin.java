package test;

import org.testng.annotations.Test;

public class wdiodemoAppLogin extends MobileTestBase {

    @Test(priority=1)
    public void verifyLoginButtonIsDisplayed(){

        page.wdiodemoAppHomePage().LoginButtonIsDisplayed();

    }


    @Test(dependsOnMethods = "verifyLoginButtonIsDisplayed")
    public void verifyClickonLoginButton(){
        page.wdiodemoAppHomePage().LoginButtonIsDisplayed();
        page.wdiodemoAppHomePage().clickLoginTap();
    }

    @Test(dependsOnMethods = "verifyClickonLoginButton")
    public void Login(){
        page.wdiodemoAppSingUP().FillEmailTextBox(System.getProperty("Email"));
        page.wdiodemoAppSingUP().FillPassword_SignUP(System.getProperty("Password"));
        page.wdiodemoAppSingUP().clickLoginButton();
        page.wdiodemoAppSingUP().signUp_successMessage_displayed();

    }

}
