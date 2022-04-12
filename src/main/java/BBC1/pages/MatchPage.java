package BBC1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MatchPage extends BasePage {

    @FindBy(xpath = "//span[contains(@class,'qa-full-team-name')]")
    private WebElement firstTeam;
    @FindBy(xpath = "(//span[contains(@class,'qa-full-team-name')])[2]")
    private WebElement secondTeam;
    @FindBy(xpath = "//span[contains(@class,'number--home')]")
    private WebElement scoreOfFirstTeam;
    @FindBy(xpath = "//span[contains(@class,'number--away')]")
    private WebElement scoreOfSecondTeam;

    public MatchPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstTeam() {
        return firstTeam.getText();
    }

    public String getSecondTeam() {
        return secondTeam.getText();
    }

    public String getScore() {
        return scoreOfFirstTeam.getText().concat(" ").concat(scoreOfSecondTeam.getText());
    }
}
