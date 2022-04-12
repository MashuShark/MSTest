package BBC1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SoresAndFixturesPage extends BasePage {

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchBar;

    @FindBy(xpath = "//span[@role='text']//mark")
    private WebElement searchBarHint;

    public static final String XPATH_FOR_PERIOD = "//a[contains(@href,'fixtures/%s')]";

    @FindBy(xpath = "//span[contains(@class,'qa-full-team-name')]")
    private WebElement nameOfFirstTeam;

    @FindBy(xpath = "(//span[contains(@class,'qa-full-team-name')])[2]")
    private WebElement nameOfSecondTeam;

    @FindBy(xpath = "//span[contains(@class,'number--home')]")
    private WebElement scoreOfFirstTeam;

    @FindBy(xpath = "//span[contains(@class,'number--away')]")
    private WebElement scoreOfSecondTeam;

    public SoresAndFixturesPage(WebDriver driver) {
        super(driver);
    }

    public void searchFootballScoresAndFixtures(String textForSearching) {
        enterText(searchBar, textForSearching, searchBarHint);
    }

    public void selectPeriod(String period) {
        WebElement selectedPeriod = getTextLocator(XPATH_FOR_PERIOD, period);
        moveToElement(selectedPeriod);
        clickOnElement(selectedPeriod);
    }

    public void openMatchResultPage() {
        waitVisibilityOfElement(60, nameOfFirstTeam);
        moveToElement(nameOfFirstTeam);
        nameOfFirstTeam.click();
    }

    public String getFirstTeam() {
        waitVisibilityOfElement(60, nameOfFirstTeam);
        return nameOfFirstTeam.getText();
    }

    public String getSecondTeam() {
        return nameOfSecondTeam.getText();
    }

    public String getScore() {
        return scoreOfFirstTeam.getText().concat(" ").concat(scoreOfSecondTeam.getText());
    }

}
