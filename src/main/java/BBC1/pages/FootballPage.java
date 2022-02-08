package BBC1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FootballPage extends BasePage{

    @FindBy(xpath = "//a[@data-stat-title='Scores & Fixtures']")
    private WebElement scoresAndFixturesCategory;

    public FootballPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSoresAndFixturesButton(){
        clickOnElement(scoresAndFixturesCategory);
    }

}
