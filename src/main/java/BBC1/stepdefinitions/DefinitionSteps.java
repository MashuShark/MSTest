package BBC1.stepdefinitions;

import BBC1.manager.PageFactoryManager;
import BBC1.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    WebDriver driver;
    HomePage homePage;
    NewsPage newsPage;
    SearchResultPage searchResultPage;
    CoronavirusCategoryPage coronavirusCategoryPage;
    UsersCoronavirusStoryPage usersCoronavirusStoryPage;
    UsersQuestionsPage usersQuestionsPage;
    Form form;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

//    private final String NAME_OF_HEADLINER_ARTICLE = "Djokovic 'grateful' after winning Australia court battle";

//    private final String ARTICLE_2 = "Kazakhstan unrest was coup attempt, says president";
//    private final String ARTICLE_3 = "Colds may give some Covid protection - study";
//    private final String ARTICLE_4 = "Celebrations revealed for Queen's Platinum Jubilee";
//    private final String ARTICLE_5 = "Past seven years hottest on record - EU data";
//    private final String ARTICLE_6 = "Ikea cuts sick pay for some unvaccinated staff";

    private final String ERROR_MESSAGE_MISSING_EMAIL = "Email address can't be blank";

    private String titleOfCategory;

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User opens News")
    public void openNews() {
        homePage.clickOnNewsButton();
        newsPage = pageFactoryManager.getNewsPage();
    }

    @And("Checks the name of the headline article against a {string}")
    public void checkNameOfTHeadlineArticle(final String title) {
        Assert.assertEquals(newsPage.getNameOfHeadlineArticle(), title);
    }

    @And("Checks the name of the second article against a {string}")
    public void checkSecondArticle(final String SECOND_TITLE) {
        Assert.assertEquals(newsPage.getNameOfArticle2(), SECOND_TITLE);
    }

    @And("Checks the name of the third article against a {string}")
    public void checkThirdArticle(final String THIRD_TITLE) {
        Assert.assertEquals(newsPage.getNameOfArticle3(), THIRD_TITLE);
    }

    @And("Checks the name of the fourth article against a {string}")
    public void checkFourthArticle(final String FOURTH_TITLE) {
        Assert.assertEquals(newsPage.getNameOfArticle4(), FOURTH_TITLE);
    }

    @And("Checks the name of the fifth article against a {string}")
    public void checkFifthArticle(final String FIFTH_TITLE) {
        Assert.assertEquals(newsPage.getNameOfArticle5(), FIFTH_TITLE);
    }

    @And("Checks the name of the sixth article against a {string}")
    public void checkSixthArticle(final String SIXTH_TITLE) {
        Assert.assertEquals(newsPage.getNameOfArticle6(), SIXTH_TITLE);
    }

    @And("User enters title of Category in search field")
    public void enterTitleInSearchField() {
        String titleOfCategory = newsPage.getNameOfCategory();
        homePage.enterTextInSearchBar(titleOfCategory);
    }

    @And("Checks the name of the first in category article against a {string}")
    public void checkNameOfFirstInCategoryArticleAgainstNameOfCategory() {
        Assert.assertEquals(searchResultPage.getNameOfFirstArticle(), titleOfCategory);
    }

    @And("User opens Coronavirus category")
    public void openCoronavirusCategory() {
        newsPage.clickOnCoronavirusCategory();
    }

    @And("User opens User Coronavirus Story Page")
    public void openUserCoronavirusStoryPage() {
        coronavirusCategoryPage.clickOnUsersCoronavirusStoryButton();
    }

    @And("User opens User Questions Page")
    public void openUserQuestionsPage() {
        usersCoronavirusStoryPage.clickOnUsersQuestionsLink();
        usersCoronavirusStoryPage.waitLoadPage(60);
    }

    @And("User moves to form for user questions")
    public void userMovesToFormForUserQuestions() {
        usersQuestionsPage.waitElementToBeClicable(60, usersQuestionsPage.getClosePopupButton());
        usersQuestionsPage.clickClosePopupButton();
        usersQuestionsPage.moveToFormForUsersQuestions();
    }


    @And("Checks  email error message {string}")
    public void checksEmailErrorMessageError_message_missing_email(final String error_message_missing_email) {
        Assert.assertEquals(usersQuestionsPage.getErrorMessageMissingEmail(), error_message_missing_email);
    }


    @After
    public void tearDown(){
        driver.close();
    }
}
