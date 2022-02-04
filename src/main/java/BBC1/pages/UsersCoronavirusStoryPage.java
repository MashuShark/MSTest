package BBC1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersCoronavirusStoryPage extends BasePage{

    @FindBy(xpath= "//a[@href='/news/52143212']")
    private WebElement usersQuestionsLink;

    public UsersCoronavirusStoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnUsersQuestionsLink(){
        moveToElement(usersQuestionsLink);
        usersQuestionsLink.click();
    }
}
