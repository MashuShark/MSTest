package BBC1.stepdefinitions;

import BBC1.manager.PageFactoryManager;
import BBC1.pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.openqa.selenium.By.xpath;

public class DefinitionSteps {

    static WebDriver driver;
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
        titleOfCategory = newsPage.getNameOfCategory();
        homePage.enterTextInSearchBar(titleOfCategory);
    }

    @And("Checks the name of the first in category article against a title of Category")
    public void checkNameOfFirstInCategoryArticleAgainstNameOfCategory() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        Assert.assertTrue(searchResultPage.getNameOfFirstArticle().contains(titleOfCategory));
    }

    @And("User opens Coronavirus category")
    public void openCoronavirusCategory() {
        newsPage.clickOnCoronavirusCategory();
        coronavirusCategoryPage = pageFactoryManager.getCoronavirusCategoryPage();
    }

    @And("User opens User Coronavirus Story Page")
    public void openUserCoronavirusStoryPage() {
        coronavirusCategoryPage.clickOnUsersCoronavirusStoryButton();
        usersCoronavirusStoryPage = pageFactoryManager.getUsersCoronavirusStoryPage();
    }

    @And("User opens User Questions Page")
    public void openUserQuestionsPage() {
        usersCoronavirusStoryPage.clickOnUsersQuestionsLink();
        usersQuestionsPage = pageFactoryManager.getUsersUsersQuestionsPage();
        usersQuestionsPage.waitLoadPage(60);
    }

    @And("User moves to form for user questions")
    public void userMovesToFormForUserQuestions() {
        usersQuestionsPage.waitElementToBeClicable(60, usersQuestionsPage.getClosePopupButton());
        usersQuestionsPage.clickClosePopupButton();
        usersQuestionsPage.moveToFormForUsersQuestions();
    }

    @And("User enters question")
    public void enterQuestion() {
        usersQuestionsPage.fillQuestionsInput();
    }


//    Map<String, String> userData = new HashMap<String, String>();
//    {
//        userData.put("Name", "Alex");
//        userData.put("Email address", "");
//        userData.put("Contact number", "1234567890");
//        userData.put("Location ", "Monaco");
//        userData.put("Age", "20");
//    }
//
//    public static WebElement getTextXpath(String text) {
//        return driver.findElement(xpath("//input[@placeholder='" + text + "']"));
//    }
//
//    @And("User fills form")
//    public void fillForm() {
////        Map<String, String> values = dataTable.asMap();
////        form = pageFactoryManager.getForm();
//        for ( Map.Entry entry: userData.entrySet())
//            getTextXpath(String.valueOf(entry.getKey())).sendKeys(String.valueOf(entry.getValue()));
//
//    }

    @And("User fills form")
    public void fillForm(Map<String, String> values) {
//        Map<String, String> values = dataTable.asMap();
//        form = pageFactoryManager.getForm();
        for ( Map.Entry entry: values.entrySet())
            usersQuestionsPage.getTextXpath(String.valueOf(entry.getKey())).sendKeys(String.valueOf(entry.getValue()));

    }

    @And("User selects dropdown")
    public void userSelectDropdown() {
        usersQuestionsPage.selectValueFromDropdown();
    }

    @And("User sends form")
    public void userSendsForm() {
        usersQuestionsPage.clickOnSubmitButton();
    }

    @When("Checks email error message")
    public void checksEmailErrorMessageError_message_missing_email() {
        usersQuestionsPage.waitVisibilityOfElement(60, usersQuestionsPage.getErrorMessageMissingEmail());
        Assert.assertEquals(ERROR_MESSAGE_MISSING_EMAIL, usersQuestionsPage.getErrorMessageMissingEmailText());
    }

    @And("User clicks on Submit Button")
    public void clickOnSubmitButton() {
        usersQuestionsPage.clickOnSubmitButton();
    }

    @After
    public void tearDown(){
        driver.close();
    }

}
