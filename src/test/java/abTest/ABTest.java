package abTest;

import core.BaseDriver;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.testPages.ABTestPage;

public class ABTest extends BaseDriver {

    @Test
    public void testSuccessfulABTest(){

        String titleA = "A/B Test Variation 1";
        String titleAControl = "A/B Test Control";
        String contentA = "Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).";
        String titleB = "No A/B Test";
        String contentB = "Also known as split testing. This is a way in which businesses are able to simultaneously test and learn from different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).";

        ABTestPage abTestPage = mainPage.clickABTest();
        Assert.assertTrue(abTestPage.getTitleText().equals(titleA) || abTestPage.getTitleText().equals(titleAControl));
        Assert.assertEquals(abTestPage.getContentText(), contentA, "Content text is not correct");
        driver.manage().addCookie(new Cookie("optimizelyOptOut", "true"));
        driver.navigate().refresh();
        Assert.assertEquals(abTestPage.getTitleText(), titleB, "Title text is not correct");
        Assert.assertEquals(abTestPage.getContentText(), contentB, "Content text is not correct");
    }
}
