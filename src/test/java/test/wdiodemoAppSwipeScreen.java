package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class wdiodemoAppSwipeScreen extends MobileTestBase {

    @Test(priority=1)
    public void verifySwipeisDisplayed(){


        Assert.assertTrue(page.wdiodemoAppHomePage().SwipTap_isDisplayed());

    }


    @Test(dependsOnMethods = "verifySwipeisDisplayed")
    public void verifyClickonSwipeTab(){
        page.wdiodemoAppHomePage().clickSwipe();
    }

    @Test(dependsOnMethods = "verifyClickonSwipeTab")
    public void swipeUntilSupportVideos(){
        page.wdiodemoAppSwipePage().swipeToSupportVideos();
        Assert.assertTrue(page.wdiodemoAppSwipePage().supportVideosCard_isDisplayed());

    }

}
