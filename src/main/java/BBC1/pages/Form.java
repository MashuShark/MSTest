package BBC1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

import static org.openqa.selenium.By.xpath;

public class Form extends BasePage{

//    public void fillForm(Map<String, String> values) {
//        for ( Map.Entry entry: values.entrySet())
//            UsersQuestionsPage.getTextXpath(String.valueOf(entry.getKey())).sendKeys(String.valueOf(entry.getValue()));
//    }

    public Form(WebDriver driver) {
        super(driver);
    }

//    Map<String, String> userData = new HashMap<String, String>();
//    {
//        userData.put("Name", "Alex");
//        userData.put("Email address", "");
//        userData.put("Contact number", "1234567890");
//        userData.put("Location ", "Monaco");
//        userData.put("Age", "20");
//    }

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

}
