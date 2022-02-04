package BBC1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class UsersCoronavirusStoryPage extends BasePage{

    @FindBy(xpath= "//a[@href='/news/52143212']")
    private WebElement usersQuestionsLink;

    public UsersCoronavirusStoryPage(WebDriver driver) {
        super(driver);
    }

    private void moveToElement(WebElement element){
        Actions moveTo = new Actions(driver);
        moveTo.moveToElement(element);
//        moveTo.perform();
    }

    public void clickOnUsersQuestionsLink(){
        moveToElement(usersQuestionsLink);
        usersQuestionsLink.click();
    }
}
