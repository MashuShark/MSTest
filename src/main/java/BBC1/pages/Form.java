package BBC1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class Form extends BasePage{


    public Form(WebDriver driver) {
        super(driver);
    }

//    public void FillForm(Dictionary<String, String> values) {
//
//    }
//
    public HashMap<String, String> getUserData(){
        HashMap<String, String> userData = new HashMap<String, String>();

        userData.put("What questions would you like us to answer?", "Some text for verify form");
        userData.put("Name", "Alex");
        userData.put("Email address", null);
        userData.put("Contact number", "1234567890");
        userData.put("Location ", "Monaco");
        userData.put("Age", "20");

        return userData;
    }

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@placeholder='Email address']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[contains(@placeholder,'number')]")
    private WebElement numberInput;

    @FindBy(xpath = "//input[contains(@placeholder,'Location')]")
    private WebElement locationInput;

    @FindBy(xpath = "//input[contains(@placeholder,'Age')]")
    private WebElement ageInput;

    @FindBy(xpath = "//textarea[contains(@placeholder,'questions')]")
    private WebElement questionsInput;

    @FindBy(xpath = "//div[@class='button-container']//button[text()='Submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class=\"checkbox\"]//input[@type=\"checkbox\"]")
    private WebElement checkBox;

    @FindBy(xpath = "//div[@class='checkbox']//input[@type='checkbox']")
    private WebElement checkboxButton;

    public void fillNameInput(){
//        nameInput.sendKeys(getUserData.get("Name"));
        nameInput.sendKeys("Alex");
    }
    public void fillEmailInput(){
        emailInput.sendKeys("");
    }

    public void fillNumberInput(){
        numberInput.sendKeys("1234567890");
    }

    public void fillLocationInput(){
        locationInput.sendKeys("Monaco");
    }

    public void fillAgeInput(){
        ageInput.sendKeys("20");
    }

    public void fillQuestionsInput(){
        questionsInput.sendKeys("Some text for verify form");
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }

    public void selectValueFromDropdown(){
        checkboxButton.click();
//        Select day =new Select(checkBox);
//        day.selectByVisibleText("I accept the ");
    }
}
