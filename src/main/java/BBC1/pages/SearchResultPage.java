package BBC1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {

    @FindBy(xpath= "//p[contains(@class,'PromoHeadline')]/span")
    private WebElement nameOfFirstArticle;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getNameOfFirstArticle(){
        return nameOfFirstArticle.getText();
    }
}
