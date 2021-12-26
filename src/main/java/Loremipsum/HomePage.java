package Loremipsum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='Languages']//a[@href='http://ru.lipsum.com/']")
    private WebElement ruVersionSite;

    @FindBy(xpath = "//div[@id='Panes']//p")
    private WebElement firstParagraph;

    private String textFromFirstParagraph = firstParagraph.getText();

    @FindBy(xpath = "//tbody//input[@name='generate']")
    private WebElement generateLoremIpsumButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToRuVersionSite(){
        ruVersionSite.click();
    }

    public String getTextFromFirstParagraph(){
        return textFromFirstParagraph;
    }

    private void moveToElement(WebElement element){
        Actions moveTo = new Actions(driver);
        moveTo.moveToElement(element);
        moveTo.perform();
    }

    public void moveAndClickGenerateLoremIpsumButton(){
        moveToElement(generateLoremIpsumButton);
        generateLoremIpsumButton.click();
    }
}
