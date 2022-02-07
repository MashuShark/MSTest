package BBC1.stepdefinitions;

import BBC1.manager.PageFactoryManager;
import BBC1.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

import static BBC1.pages.UsersQuestionsPage.FORM_LOCATOR;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

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

    private String titleOfCategory;

    @Before
    public void testSetUp(){
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String listOfStringListsType(String cell) {
        return cell;
    }

    @And("User opens {string} page")
    public void openPage(final String url){
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
        Assert.assertEquals("The title of the headline article title does not match what is expected",
                title, newsPage.getNameOfHeadlineArticle());
    }

    @And("Checks that name of secondary articles are correct")
    public void checksNameOfSecondaryArticles(List<String> names) {
        Assert.assertEquals("The title of the second articles title do not match what is expected",
                names, newsPage.getNameOfSecondaryArticles());
    }

    @And("User enters title of Category in search field")
    public void enterTitleInSearchField() {
        titleOfCategory = newsPage.getNameOfCategory();
        homePage.enterTextInSearchBar(titleOfCategory);
    }

    @And("Checks the name of the first in category article against a title of Category")
    public void checkNameOfFirstInCategoryArticleAgainstNameOfCategory() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        Assert.assertTrue("The name of the first article in the search result does not contain the name of Category",
                searchResultPage.getNameOfFirstArticle().contains(titleOfCategory));
    }

    @And("User opens Coronavirus category")
    public void openCoronavirusCategory() {
        newsPage.clickOnCoronavirusCategoryButton();
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
        usersQuestionsPage.closePopupButton();
        usersQuestionsPage.moveToFormForUsersQuestions();
    }

    @And("User fills form")
    public void fillForm(Map<String, String> entry) {
        form = pageFactoryManager.getForm();
        form.fillForm(entry, FORM_LOCATOR);
    }

    @And("User selects dropdown")
    public void userSelectDropdown() {
        usersQuestionsPage.selectValueFromDropdown();
    }

    @And("User sends form")
    public void userSendsForm() {
        usersQuestionsPage.clickOnSubmitButton();
    }

    @When("User checks {string} message")
    public void checksEmailErrorMessageError_message_missing_email(final String error) {
       usersQuestionsPage.waitVisibilityOfElement(60, usersQuestionsPage.getErrorMessageMissingEmail());
        Assert.assertTrue("The expected error message does not visible",
                usersQuestionsPage.getErrorMessageMissingEmailText().contains(error));
    }

    @After
    public void tearDown(){
        driver.close();
    }

}
