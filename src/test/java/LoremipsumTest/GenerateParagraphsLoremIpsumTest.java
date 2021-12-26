package LoremipsumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GenerateParagraphsLoremIpsumTest extends BaseTest{

    private final String EXPECTED_FIRST_SENTENCE = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";

    @Test
    public void verifyDefaultTextSettingResultNewLoremIpsum(){
        getHomePage().moveAndClickGenerateLoremIpsumButton();
        getGenerateParagraphsLoremIpsumPage().implicitWait(30);
        Assert.assertEquals(getGenerateParagraphsLoremIpsumPage().paragraphStartWith(), EXPECTED_FIRST_SENTENCE);
    }
}
