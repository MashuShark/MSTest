package BBC1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.naming.ldap.PagedResultsControl;
import java.util.HashMap;
import java.util.Map;

import static org.openqa.selenium.By.xpath;

public class Form extends BasePage{

    private String QUESTION = "Some text for verify form";

    public Form(WebDriver driver) {
        super(driver);
    }

    Map<String, String> userData = new HashMap<String, String>();
    {
        userData.put("Name", "Alex");
        userData.put("Email address", "");
        userData.put("Contact number", "1234567890");
        userData.put("Location ", "Monaco");
        userData.put("Age", "20");
    }

    public WebElement getTextXpath(String text) {
        return driver.findElement(xpath("//input[@placeholder='" + text + "']"));
    }

    public void fillUserContacts(){
        for ( Map.Entry entry: userData.entrySet())
            getTextXpath(String.valueOf(entry.getKey())).sendKeys(String.valueOf(entry.getValue()));
    }

//    @FindBy(xpath = "//input[@placeholder='Name']")
//    private WebElement nameInput;
//
//    @FindBy(xpath = "//input[@placeholder='Email address']")
//    private WebElement emailInput;
//
//    @FindBy(xpath = "//input[contains(@placeholder,'number')]")
//    private WebElement numberInput;
//
//    @FindBy(xpath = "//input[contains(@placeholder,'Location')]")
//    private WebElement locationInput;
//
//    @FindBy(xpath = "//input[contains(@placeholder,'Age')]")
//    private WebElement ageInput;

    @FindBy(xpath = "//textarea[contains(@placeholder,'questions')]")
    private WebElement questionsInput;

    @FindBy(xpath = "//div[@class='button-container']//button[text()='Submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class=\"checkbox\"]//input[@type=\"checkbox\"]")
    private WebElement checkBox;

    @FindBy(xpath = "//div[@class='checkbox']//input[@type='checkbox']")
    private WebElement checkboxButton;

    public void fillQuestionsInput(){
        questionsInput.sendKeys(QUESTION);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }

    public void selectValueFromDropdown(){
        checkboxButton.click();
    }
}
