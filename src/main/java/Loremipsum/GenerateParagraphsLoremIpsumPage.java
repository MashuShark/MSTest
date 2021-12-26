package Loremipsum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GenerateParagraphsLoremIpsumPage extends BasePage{

    @FindBy(xpath = "//div[@id='lipsum']/p[1]")
    private WebElement firstParagraph;

    public GenerateParagraphsLoremIpsumPage(WebDriver driver) {
        super(driver);
    }

    public String paragraphStartWith(){
        String textFromParagraph = firstParagraph.getText();
        String firstSentenceFromFirstParagraph = textFromParagraph.split("\\.")[0];
        return firstSentenceFromFirstParagraph;
    }
}
