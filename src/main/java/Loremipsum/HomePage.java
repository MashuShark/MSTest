package Loremipsum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='Languages']//a[@href='http://ru.lipsum.com/']")
    private WebElement ruVersionSite;

    @FindBy(xpath = "//div[@id='Panes']//p/text()")
    private String textOfFirstParagraph;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToRuVersionSite(){
        ruVersionSite.click();
    }

    public String getTextOfFirstParagraph(){
        return textOfFirstParagraph;
    }
//    public String getTextOfFirstParagraph(){
//        return textOfFirstParagraph.getAttribute("innerhtml");
//    }
}
