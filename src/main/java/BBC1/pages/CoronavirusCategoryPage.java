package BBC1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoronavirusCategoryPage extends BasePage{

    @FindBy(xpath = "//li[contains(@class,'secondary-menuitem-container')]//a[@class='nw-o-link']")
    private WebElement usersCoronavirusStoryButton;

    public CoronavirusCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnUsersCoronavirusStoryButton(){
        usersCoronavirusStoryButton.click();
    }

}
