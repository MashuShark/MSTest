package LoremipsumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GenerateParagraphsLoremIpsumTest extends BaseTest{

    private final String START_WITH_LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
    private final int TEN_WORDS = 10;
    private final int NEGATIVE_WORD_AMOUNT = -1;
    private final int ZERO_WORDS = 0;
    private final int TWENTY_WORDS = 20;
    private final int FIVE_WORDS = 5;

    private final int FIVE_CHARACTERS = 5;
    private final int TEN_CHARACTERS = 10;
    private final int TWENTY_CHARACTERS = 20;
    private final int ZERO_CHARACTERS = 0;

    //If input <=0 -> get default size(5)

    @Test
    public void verifyDefaultTextSettingResultNewLoremIpsum(){
        getHomePage().moveAndClickGenerateLoremIpsumButton();
        getGenerateParagraphsLoremIpsumPage().waitLoadPage(30);
        Assert.assertEquals(
                getGenerateParagraphsLoremIpsumPage().paragraphStartWith(), START_WITH_LOREM_IPSUM);
    }

   @Test
    public void verifyThatLoremIpsumIsGeneratedWithTenWords(){
        getHomePage().moveAndClickWordsRadioButton();
        getHomePage().setInputSizeLoremIpsum(TEN_WORDS);
        getHomePage().moveAndClickGenerateLoremIpsumButton();
        getGenerateParagraphsLoremIpsumPage().waitLoadPage(30);
        Assert.assertEquals(getGenerateParagraphsLoremIpsumPage().getAmountOfWords(), TEN_WORDS);
    }

    @Test
    public void verifyThatLoremIpsumIsGeneratedWithZeroWords(){
        getHomePage().moveAndClickWordsRadioButton();
        getHomePage().setInputSizeLoremIpsum(ZERO_WORDS);
        getHomePage().moveAndClickGenerateLoremIpsumButton();
        getGenerateParagraphsLoremIpsumPage().waitLoadPage(30);
        Assert.assertEquals(getGenerateParagraphsLoremIpsumPage().getAmountOfWords(), FIVE_WORDS);
    }

    @Test
    public void verifyThatLoremIpsumIsGeneratedWithFiveWords(){
        getHomePage().moveAndClickWordsRadioButton();
        getHomePage().moveAndClickGenerateLoremIpsumButton();
        getGenerateParagraphsLoremIpsumPage().waitLoadPage(30);
        Assert.assertEquals(getGenerateParagraphsLoremIpsumPage().getAmountOfWords(), FIVE_WORDS);
    }

    @Test
    public void verifyThatLoremIpsumIsGeneratedWithTwentyWords(){
        getHomePage().moveAndClickWordsRadioButton();
        getHomePage().setInputSizeLoremIpsum(TWENTY_WORDS);
        getHomePage().moveAndClickGenerateLoremIpsumButton();
        getGenerateParagraphsLoremIpsumPage().waitLoadPage(30);
        Assert.assertEquals(getGenerateParagraphsLoremIpsumPage().getAmountOfWords(), TWENTY_WORDS);
    }

     @Test
    public void verifyThatLoremIpsumIsGeneratedWithNegativeWordAmount(){
        getHomePage().moveAndClickWordsRadioButton();
        getHomePage().setInputSizeLoremIpsum(NEGATIVE_WORD_AMOUNT);
        getHomePage().moveAndClickGenerateLoremIpsumButton();
        getGenerateParagraphsLoremIpsumPage().waitLoadPage(30);
        Assert.assertEquals(getGenerateParagraphsLoremIpsumPage().getAmountOfWords(), FIVE_WORDS);
    }

    @Test
    public void verifyThatLoremIpsumIsGeneratedWithTenChars(){
        getHomePage().moveAndClickBytesRadioButton();
        getHomePage().setInputSizeLoremIpsum(TEN_CHARACTERS);
        getHomePage().moveAndClickGenerateLoremIpsumButton();
        getGenerateParagraphsLoremIpsumPage().waitLoadPage(30);
        Assert.assertEquals(getGenerateParagraphsLoremIpsumPage().getAmountOfCharacters(), TEN_CHARACTERS);
    }

    @Test
    public void verifyThatLoremIpsumIsGeneratedWithTwentyChars(){
        getHomePage().moveAndClickBytesRadioButton();
        getHomePage().setInputSizeLoremIpsum(TWENTY_CHARACTERS);
        getHomePage().moveAndClickGenerateLoremIpsumButton();
        getGenerateParagraphsLoremIpsumPage().waitLoadPage(30);
        Assert.assertEquals(getGenerateParagraphsLoremIpsumPage().getAmountOfCharacters(), TWENTY_CHARACTERS);
    }

    @Test
    public void verifyThatLoremIpsumIsGeneratedWithZeroChars(){
        getHomePage().moveAndClickBytesRadioButton();
        getHomePage().setInputSizeLoremIpsum(ZERO_CHARACTERS);
        getHomePage().moveAndClickGenerateLoremIpsumButton();
        getGenerateParagraphsLoremIpsumPage().waitLoadPage(30);
        Assert.assertEquals(getGenerateParagraphsLoremIpsumPage().getAmountOfCharacters(), FIVE_CHARACTERS);
    }

    @Test
    public void verifyTheCheckbox(){
        getHomePage().moveAndUncheckCheckbox();
        getHomePage().moveAndClickGenerateLoremIpsumButton();
        getGenerateParagraphsLoremIpsumPage().waitLoadPage(30);
        Assert.assertNotEquals(
                getGenerateParagraphsLoremIpsumPage().paragraphStartWith(), START_WITH_LOREM_IPSUM);
    }


    public void checkThatParagraphsContainLoremMoreThan40Percent(){
        getHomePage().moveAndClickGenerateLoremIpsumButton();

        System.out.println(getGenerateParagraphsLoremIpsumPage().getAVGAmountLoremInText());
        System.out.println(getGenerateParagraphsLoremIpsumPage().getTextFromParagraph());
        System.out.println(getGenerateParagraphsLoremIpsumPage().getTextFromParagraph2());
        System.out.println(getGenerateParagraphsLoremIpsumPage().getTextFromParagraph3());
        System.out.println(getGenerateParagraphsLoremIpsumPage().getTextFromParagraph4());
        System.out.println(getGenerateParagraphsLoremIpsumPage().getTextFromParagraph5());
    }



}
