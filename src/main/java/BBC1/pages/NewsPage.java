package BBC1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//div[@class='gs-c-promo-body gs-u-display-none gs-u-display-inline-block@m gs-u-mt@xs gs-u-mt0@m gel-1/3@m']//h3[@class='gs-c-promo-heading__title gel-paragon-bold nw-o-link-split__text']")
    private WebElement nameOfHeadlineArticle;

    @FindBy(xpath = "//div[@class='gel-layout__item nw-c-top-stories__secondary-item gel-1/1 gel-1/3@m gel-1/4@l nw-o-keyline nw-o-no-keyline@m gs-u-float-left nw-c-top-stories__secondary-item--1 gel-3/16@xxl gs-u-float-none@xxl gs-u-mt gs-u-mt0@xs']//h3[@class='gs-c-promo-heading__title gel-pica-bold nw-o-link-split__text']")
    private WebElement article2;
    @FindBy(xpath = "//div[@class='gel-layout__item nw-c-top-stories__secondary-item gel-1/1 gel-1/3@m gel-1/4@l nw-o-keyline nw-o-no-keyline@m gs-u-float-left nw-c-top-stories__secondary-item--2 gel-1/5@xxl']//h3[@class='gs-c-promo-heading__title gel-pica-bold nw-o-link-split__text']")
    private WebElement article3;
    @FindBy(xpath = "//div[@class='gel-layout__item nw-c-top-stories__secondary-item gel-1/1 gel-1/3@m gel-1/4@l nw-o-keyline nw-o-no-keyline@m gs-u-float-left nw-c-top-stories__secondary-item--3 gel-1/5@xxl']//h3[@class='gs-c-promo-heading__title gel-pica-bold nw-o-link-split__text']")
    private WebElement article4;
    @FindBy(xpath = "//div[@class='gel-layout__item nw-c-top-stories__secondary-item gel-1/1 gel-1/3@m gel-1/4@l nw-o-keyline nw-o-no-keyline@m gs-u-float-left nw-c-top-stories__secondary-item--4 gel-1/5@xxl']//h3[@class='gs-c-promo-heading__title gel-pica-bold nw-o-link-split__text']")
    private WebElement article5;
    @FindBy(xpath = "//div[@class='gel-layout__item nw-c-top-stories__secondary-item gel-1/1 gel-1/3@m gel-1/4@l nw-o-keyline nw-o-no-keyline@m gs-u-float-left nw-c-top-stories__secondary-item--5 gel-1/5@xxl']//h3[@class='gs-c-promo-heading__title gel-pica-bold nw-o-link-split__text']")
    private WebElement article6;

    @FindBy(xpath = "//a[contains(@class,'nw-o-link--no-visited-state')]")
    private WebElement nameOfCategory;

    @FindBy(xpath = "//ul[@class='gs-o-list-ui--top-no-border nw-c-nav__wide-sections']//a[contains(@href,'coronavirus')]")
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
    public String getNameOfArticle6(){
        return article6.getText();
    }

    public String getNameOfCategory(){
        return nameOfCategory.getText();
    }

    public void clickOnCoronavirusCategory(){
        coronavirusCategory.click();
    }
}
