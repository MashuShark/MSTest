package BBC1;

public class NewsTests {

    private final String NAME_OF_HEADLINER_ARTICLE = "Djokovic 'grateful' after winning Australia court battle";

    private final String ARTICLE_2 = "Kazakhstan unrest was coup attempt, says president";
    private final String ARTICLE_3 = "Colds may give some Covid protection - study";
    private final String ARTICLE_4 = "Celebrations revealed for Queen's Platinum Jubilee";
    private final String ARTICLE_5 = "Past seven years hottest on record - EU data";
    private final String ARTICLE_6 = "Ikea cuts sick pay for some unvaccinated staff";

    private final String ERROR_MESSAGE_MISSING_EMAIL= "Email address can't be blank";



//    @Test
//    public void checkNameOfHeadlineArticle(){
//        getHomePage().clickOnNewsButton();
//        Assert.assertEquals(getNewsPage().getNameOfHeadlineArticle(),NAME_OF_HEADLINER_ARTICLE);
//    }

//    @Test
//    public void checkSecondaryArticleTitles(){
//        getHomePage().clickOnNewsButton();
//        Assert.assertEquals(getNewsPage().getNameOfArticle2(), ARTICLE_2);
//        Assert.assertEquals(getNewsPage().getNameOfArticle3(), ARTICLE_3);
//        Assert.assertEquals(getNewsPage().getNameOfArticle4(), ARTICLE_4);
//        Assert.assertEquals(getNewsPage().getNameOfArticle5(), ARTICLE_5);
//        Assert.assertEquals(getNewsPage().getNameOfArticle6(), ARTICLE_6);
//    }

//    @Test
//    public void checkNameOfFirstArticleAgainstSpecifiedValue(){
//        getHomePage().clickOnNewsButton();
//        String titleOfCategory = getNewsPage().getNameOfCategory();
//        getHomePage().enterTextInSearchBar(getNewsPage().getNameOfCategory());
//        Assert.assertTrue(getSearchResultPage().getNameOfFirstArticle().contains(titleOfCategory));
//    }

//    @Test
//    public void checkFormUsersQuestion(){
//        getHomePage().clickOnNewsButton();
//        getNewsPage().clickOnCoronavirusCategory();
//        getCoronavirusCategoryPage().clickOnUsersCoronavirusStoryButton();
//        getUsersCoronavirusStoryPage().waitLoadPage(60);
//        getUsersCoronavirusStoryPage().clickOnUsersQuestionsLink();
//        getUsersQuestionsPage().waitLoadPage(60);
//        getUsersQuestionsPage().waitElementToBeClicable(60, getUsersQuestionsPage().getClosePopupButton());
//        getUsersQuestionsPage().clickClosePopupButton();
//        getUsersQuestionsPage().moveToFormForUsersQuestions();

//        getForm().fillQuestionsInput();
//        getForm().fillNameInput();
//        getForm().fillEmailInput();
//        getForm().fillNumberInput();
//        getForm().fillLocationInput();
//        getForm().fillAgeInput();
//        getForm().clickOnSubmitButton();
//
//        getForm().selectValueFromDropdown();
//
//        Assert.assertEquals(getUsersQuestionsPage().getErrorMessageMissingEmail(), ERROR_MESSAGE_MISSING_EMAIL);
//    }

}
