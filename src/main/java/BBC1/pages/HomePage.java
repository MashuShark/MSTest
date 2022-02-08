package BBC1.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//nav[@class='orb-nav']//a[contains(text(),'News')]")
    private WebElement newsButtonHeader;

    @FindBy (xpath = "//input[@id='orb-search-q']")
    private WebElement searchBar;

    @FindBy(xpath = "//button[@id='orb-search-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(@class,'orb-nav-focus')]//a[text()='Sport']")
    private WebElement sportButtonHeader;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void clickOnNewsButton(){
        clickOnElement(newsButtonHeader);
    }

    public void enterTextInSearchBar(String textForSearching){
        searchBar.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), textForSearching);
        searchButton.click();
    }

    public void clickOnSportButton(){
        clickOnElement(sportButtonHeader);
    }
}
