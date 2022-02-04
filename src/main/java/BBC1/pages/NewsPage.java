package BBC1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'gs-u-display-inline-block@m')]//h3[contains(@class,'gs-c-promo-heading')]")
    private WebElement nameOfHeadlineArticle;

    @FindBy(xpath = "//div[contains(@class,'nw-c-top-stories--international')]//div[contains(@class,'secondary-item')]//h3")
    private List<WebElement> listOfSecondaryArticles;

    @FindBy(xpath = "//a[contains(@class,'nw-o-link--no-visited-state')]")
    private WebElement nameOfCategory;

    @FindBy(xpath = "//ul[contains(@class,'nw-c-nav__wide-sections')]//a[contains(@href,'coronavirus')]")
    private WebElement coronavirusCategory;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public String getNameOfHeadlineArticle(){
        return nameOfHeadlineArticle.getText();
    }

    public List<String> getNameOfSecondaryArticles(){
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < listOfSecondaryArticles.size() - 1; i++) {
//            list.add(i, String.valueOf(listOfSecondaryArticles.get(i).getText()));
//        }
//        return list;
        return listOfSecondaryArticles.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getNameOfCategory(){
        return nameOfCategory.getText();
    }

    public void clickOnCoronavirusCategory(){
        coronavirusCategory.click();
    }
}
