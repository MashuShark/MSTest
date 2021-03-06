package BBC1.stepdefinitions;

import BBC1.DTO.Match;
import BBC1.manager.PageFactoryManager;
import BBC1.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static BBC1.pages.UsersQuestionsPage.FORM_LOCATOR;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;

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
    SportPage sportPage;
    FootballPage footballPage;
    SoresAndFixturesPage soresAndFixturesPage;
    MatchPage matchPage;

    private String titleOfCategory;

    @Before
    public void testSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String stringType(String cell) {
        return cell;
    }

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
        assertEquals("The title of the headline article title does not match what is expected",
                title, newsPage.getNameOfHeadlineArticle());
    }

    @And("Checks that name of secondary articles are correct")
    public void checksNameOfSecondaryArticles(List<String> names) {
        assertEquals("The title of the second articles title do not match what is expected",
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
        //System.getProperty(loadPageTimout)
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

    @And("User selects {string}")
    public void selectDropdown(String yesNo) {
        if (Objects.equals(yesNo.toLowerCase(), "yes"))
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

    @And("User goes to Sport Page")
    public void goToSportPage() {
        homePage.clickOnSportButton();
        sportPage = pageFactoryManager.getSportPage();
    }

    @And("User goes to Football Page")
    public void goToFootballPage() {
        sportPage.clickOnFootballCategoryButton();
        footballPage = pageFactoryManager.getFootballPage();
    }

    @And("User goes to Scores and Fixtures")
    public void userGoesToScoresAndFixtures() {
        footballPage.clickOnSoresAndFixturesButton();
        soresAndFixturesPage = pageFactoryManager.getSoresAndFixturesPage();
    }

    @When("User searches for a {string}")
    public void searchForAChampionship(String championship) {
        soresAndFixturesPage.searchFootballScoresAndFixtures(championship);
    }

    @And("User selects results for a {string}")
    public void selectResultsForAPeriod(String period) {
        soresAndFixturesPage.selectPeriod(period);
    }

    @Then("User checks that {string} and {string} played with a specific {string}")
    public void checkTeamFirstTeamSecondScore(String firstTeam, String secondTeam, String score) {
        Match matchExpected = new Match(firstTeam, secondTeam, score);

        Match matchSearchResult = new Match(soresAndFixturesPage.getFirstTeam(),
                soresAndFixturesPage.getSecondTeam(),
                soresAndFixturesPage.getScore());

        soresAndFixturesPage.openMatchResultPage();
        matchPage = new MatchPage(driver);

        Match match = new Match(matchPage.getFirstTeam(), matchPage.getSecondTeam(), matchPage.getScore());

        // verification that the search result scope matched the expected score
        Assert.assertTrue(
                matchSearchResult.getFirstTeam().contains(matchExpected.getFirstTeam()) &&
                        matchSearchResult.getSecondTeam().contains(matchExpected.getSecondTeam()) &&
                        matchSearchResult.getScore().contains(matchExpected.getScore()));

        // verification that the search result scope matched the score on match page
        Assert.assertTrue(
                match.getFirstTeam().contains(matchSearchResult.getFirstTeam()) &&
                        match.getSecondTeam().contains(matchSearchResult.getSecondTeam()) &&
                        match.getScore().contains(matchSearchResult.getScore()));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
