package BBC1.manager;

import BBC1.pages.*;
import org.openqa.selenium.WebDriver;


public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return new HomePage(driver);
    }

    public SearchResultPage getSearchResultPage(){ return new SearchResultPage(driver);}

    public CoronavirusCategoryPage getCoronavirusCategoryPage(){ return new CoronavirusCategoryPage(driver);}

    public Form getForm(){ return new Form(driver);}

    public NewsPage getNewsPage(){ return new NewsPage(driver);}

    public UsersCoronavirusStoryPage getUsersCoronavirusStoryPage(){ return new UsersCoronavirusStoryPage(driver);}

    public UsersQuestionsPage getUsersUsersQuestionsPage(){ return new UsersQuestionsPage(driver);}

    public SportPage getSportPage(){
        return new SportPage(driver);
    }

    public FootballPage getFootballPage(){
        return new FootballPage(driver);
    }

    public SoresAndFixturesPage getSoresAndFixturesPage(){
        return new SoresAndFixturesPage(driver);
    }

    public MatchPage getMatchPage(){return new MatchPage(driver);}

}
