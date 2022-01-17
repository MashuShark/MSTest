package BBC1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class UsersQuestionsPage extends BasePage{

    @FindBy(xpath = "//div[@id='hearken-embed-module-8848-12e31']")
    private WebElement formForUsersQuestions;

    @FindBy(xpath = "//div[@class='text-input--error']//div[@class='input-error-message']")
    private WebElement errorMessageMissingEmail;

    @FindBy(xpath = "//div[@class='modal-flexBox']")
    private WebElement popup;

    @FindBy(xpath = "//button[@class='tp-close tp-active']")
    private WebElement closePopupButton;

    public UsersQuestionsPage(WebDriver driver) {
        super(driver);
    }

    private void moveToElement(WebElement element){
        Actions moveTo = new Actions(driver);
        moveTo.moveToElement(element);
    }

    public void moveToFormForUsersQuestions(){
        moveToElement(formForUsersQuestions);
    }

    public WebElement getErrorMessageMissingEmail(){
        return errorMessageMissingEmail;
    }

    public String getErrorMessageMissingEmailText(){
        return errorMessageMissingEmail.getText();
    }

//    public WebElement getPopup(){
//        return popup;
//    }

    public void clickClosePopupButton(){
        closePopupButton.click();
    }

    public WebElement getClosePopupButton(){
        return  closePopupButton;
    }

}
