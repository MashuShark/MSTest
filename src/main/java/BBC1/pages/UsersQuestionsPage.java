package BBC1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.By.xpath;

public class UsersQuestionsPage extends BasePage{

    @FindBy(xpath = "//div[contains(@id,'hearken-embed-module')]")
    private WebElement formForUsersQuestions;

    @FindBy(xpath = "//div[@class='input-error-message']")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@class='modal-flexBox']")
    private WebElement popup;

    @FindBy(xpath = "//button[@class='tp-close tp-active']")
    private WebElement closePopupButton;

    @FindBy(xpath = "//div[@class='button-container']//button[text()='Submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='checkbox']//input[@type='checkbox']")
    private WebElement checkboxButton;

    public static final String FORM_LOCATOR = "//div[@class='embed-content-container']//*[contains(@placeholder,'%s')]";

    public UsersQuestionsPage(WebDriver driver) {
        super(driver);
    }

    public void moveToFormForUsersQuestions(){
        moveToElement(formForUsersQuestions);
    }

    public WebElement getErrorMessageMissingEmail(){
        return errorMessage;
    }

    public String getErrorMessageMissingEmailText(){
        return errorMessage.getText();
    }

    public void clickClosePopupButton(){
        closePopupButton.click();
    }

    public WebElement getClosePopupButton(){
        return  closePopupButton;
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }

    public void selectValueFromDropdown(){
        checkboxButton.click();
    }

}
