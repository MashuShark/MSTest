package BBC1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'gs-u-display-inline-block@m')]//h3[contains(@class,'gs-c-promo-heading')]")
    private WebElement nameOfHeadlineArticle;

    @FindBy(xpath = "//div[contains(@class,'gs-u-mt gs-u-mt0@xs')]//h3[contains(@class,'gs-c-promo-heading')]")
    private WebElement article2;
    @FindBy(xpath = "//div[contains(@class,'secondary-item--2 gel-1/5@xxl')]//h3[contains(@class,'gs-c-promo-heading')]")
    private WebElement article3;
    @FindBy(xpath = "//div[contains(@class,'secondary-item--3 gel-1/5@xxl')]//h3[contains(@class,'gs-c-promo-heading')]")
    private WebElement article4;
    @FindBy(xpath = "//div[contains(@class,'secondary-item--4 gel-1/5@xxl')]//h3[contains(@class,'gs-c-promo-heading')]")
    private WebElement article5;

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

    public String getNameOfArticle2(){
        return article2.getText();
    }
    public String getNameOfArticle3(){
        return article3.getText();
    }
    public String getNameOfArticle4(){
        return article4.getText();
    }
    public String getNameOfArticle5(){
        return article5.getText();
    }

    public String getNameOfCategory(){
        return nameOfCategory.getText();
    }

    public void clickOnCoronavirusCategory(){
        coronavirusCategory.click();
    }
}
