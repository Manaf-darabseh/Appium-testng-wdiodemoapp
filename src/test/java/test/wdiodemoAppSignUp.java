package test;

import org.testng.annotations.Test;

public class wdiodemoAppSignUp extends MobileTestBase {

    @Test(priority=1)
    public void verifyLoginButtonIsDisplayed(){

        page.wdiodemoAppHomePage().LoginButtonIsDisplayed();

    }


    @Test(dependsOnMethods = "verifyLoginButtonIsDisplayed")
    public void verifyClickonLoginButton(){
        page.wdiodemoAppHomePage().LoginButtonIsDisplayed();
        page.wdiodemoAppHomePage().clickLoginTap();
        page.wdiodemoAppHomePage().clickSignUp();
    }

    @Test(dependsOnMethods = "verifyClickonLoginButton")
    public void SignUP(){
        page.wdiodemoAppSingUP().FillEmailTextBox(System.getProperty("Email"));
        page.wdiodemoAppSingUP().FillPassword_SignUP(System.getProperty("Password"));
        page.wdiodemoAppSingUP().FillpasswordRepeat_SignUP(System.getProperty("Password"));
        page.wdiodemoAppSingUP().clickSignUP();
        page.wdiodemoAppSingUP().signUp_successMessage_displayed();

    }

}
