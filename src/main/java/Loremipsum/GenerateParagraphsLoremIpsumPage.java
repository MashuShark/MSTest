package Loremipsum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GenerateParagraphsLoremIpsumPage extends BasePage{

    @FindBy(xpath = "//div[@id='lipsum']/p[1]")
    private WebElement firstParagraph;

    @FindBy(xpath = "//div[@id='lipsum']/p[2]")
    private WebElement secondParagraph;

    @FindBy(xpath = "//div[@id='lipsum']/p[3]")
    private WebElement thirdParagraph;

    @FindBy(xpath = "//div[@id='lipsum']/p[4]")
    private WebElement fourthParagraph;

    @FindBy(xpath = "//div[@id='lipsum']/p[5]")
    private WebElement fifthParagraph;

    private String textFromParagraph = firstParagraph.getText();
    private String textFromParagraph2 = secondParagraph.getText();
    private String textFromParagraph3 = thirdParagraph.getText();
    private String textFromParagraph4 = fourthParagraph.getText();
    private String textFromParagraph5 = fifthParagraph.getText();

    public GenerateParagraphsLoremIpsumPage(WebDriver driver) {
        super(driver);
    }

    public String paragraphStartWith(){
        String firstSentenceFromFirstParagraph = textFromParagraph.split("\\.")[0];
        return firstSentenceFromFirstParagraph;
    }

    public int getAmountOfWords(){
        String[] wordList = textFromParagraph.split(" ");
        int amountOfWords = wordList.length;
        return amountOfWords;
    }

    public int getAmountOfCharacters(){
        char[] charsList = textFromParagraph.toCharArray();
        int amountOfChars = charsList.length;
        return amountOfChars;
    }

    public double getAVGAmountLoremInText(){
        double count = 0;
        WebElement[] amountLorem = new WebElement[5];
        amountLorem[0] = firstParagraph;
        amountLorem[1] = secondParagraph;
        amountLorem[2] = thirdParagraph;
        amountLorem[3] = fourthParagraph;
        amountLorem[4] = fifthParagraph;

        for (WebElement element: amountLorem){
            if (firstParagraph.getText().toLowerCase().contains("lorem")){
                count++;
            }
        }
        return count;
    }

    public String getTextFromParagraph() {
        return textFromParagraph;
    }

    public String getTextFromParagraph2() {
        return textFromParagraph2;
    }

    public String getTextFromParagraph3() {
        return textFromParagraph3;
    }

    public String getTextFromParagraph4() {
        return textFromParagraph4;
    }

    public String getTextFromParagraph5() {
        return textFromParagraph5;
    }
}
