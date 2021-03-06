package BBC1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SportPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'MenuListContainer')]//span[text()='Football']")
    private WebElement footballCategoryButton;

    public SportPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFootballCategoryButton() {
        clickOnElement(footballCategoryButton);
    }
}
