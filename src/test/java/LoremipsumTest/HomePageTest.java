package LoremipsumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    @Test
    public void verifyThatKeywordAppearsInFirstParagraph(){
        getHomePage().goToRuVersionSite();
        getHomePage().implicitWait(30);
        Assert.assertTrue(getHomePage().getTextFromFirstParagraph().contains("рыба"));
    }

}
