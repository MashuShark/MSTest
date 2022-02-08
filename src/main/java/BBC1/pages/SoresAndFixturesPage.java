package BBC1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SoresAndFixturesPage extends BasePage{

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchBar;

    @FindBy(xpath = "//span[@role='text']//mark")
    private WebElement searchBarHint;

    public static final String XPATH_FOR_PERIOD = "//a[contains(@href,'fixtures/%s')]";

    @FindBy(xpath = "//article[@class='sp-c-fixture']//span[contains(text(),'Dunfermline')]")
    private WebElement nameOfFirstTeam;

    @FindBy(xpath = "//article[@class='sp-c-fixture']//span[contains(text(),'Arbroath')]")
    private WebElement nameOfSecondTeam;

    @FindBy(xpath = "//article[@data-event-id=\"EFBO2209359\"]//span[contains(text(),'0')]")
    private WebElement scoreOfFirstTeam;

    @FindBy(xpath = "//article[@data-event-id=\"EFBO2209359\"]//span[contains(text(),'3')]")
    private WebElement scoreOfSecondTeam;

    public SoresAndFixturesPage(WebDriver driver) {
        super(driver);
    }

    public void searchFootballScoresAndFixtures(String textForSearching){
        enterText(searchBar, textForSearching);
        searchBarHint.click();
    }

    public void selectPeriod(String period){
        WebElement selectedPeriod = getTextLocator(XPATH_FOR_PERIOD, period);
        moveToElement(selectedPeriod);
        clickOnElement(selectedPeriod);
    }

    public String getNameOfFirstTeam(){
        waitVisibilityOfElement(60, nameOfFirstTeam);
        moveToElement(nameOfFirstTeam);
        return nameOfFirstTeam.getText();
    }

    public String getNameOfSecondTeam(){
        waitVisibilityOfElement(60, nameOfSecondTeam);
        moveToElement(nameOfSecondTeam);
        return nameOfSecondTeam.getText();
    }

    public String getScore(){
        return scoreOfFirstTeam.getText().concat(" ").concat(scoreOfSecondTeam.getText());
    }

}
