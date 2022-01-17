package BBC1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {

    @FindBy(xpath= "//a[@class='ssrcss-atl1po-PromoLink e1f5wbog0']//p[@class='ssrcss-6arcww-PromoHeadline e1f5wbog4']/span")
    private WebElement nameOfFirstArticle;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getNameOfFirstArticle(){
        return nameOfFirstArticle.getText();
    }
}
