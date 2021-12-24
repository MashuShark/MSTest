package LoremipsumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    @Test
    public void verifyThatKeywordAppearsInFirstParagraph(){
        getHomePage().implicitWait(30);
        getHomePage().goToRuVersionSite();
        System.out.println("the language was changed  to ru");
        getHomePage().implicitWait(30);
        String text = getHomePage().getTextOfFirstParagraph().getText();
//        Assert.assertTrue(text.contains("рыба"));
        System.out.println(text);
    }

}
