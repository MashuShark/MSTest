package LoremipsumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import Loremipsum.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {

    private WebDriver driver;
    private static final String LOREMIPSUM_URL = "https://lipsum.com/";

    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(LOREMIPSUM_URL);
    }

    @AfterMethod
    public void treadDown(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public HomePage getHomePage(){
        return new HomePage(getDriver());
    }

    public GenerateParagraphsLoremIpsumPage getGenerateParagraphsLoremIpsumPage(){
        return new GenerateParagraphsLoremIpsumPage(getDriver());
    }
}
