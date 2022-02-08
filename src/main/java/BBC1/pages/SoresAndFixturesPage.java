package BBC1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SoresAndFixturesPage extends BasePage{

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchBar;

    public SoresAndFixturesPage(WebDriver driver) {
        super(driver);
    }


}
