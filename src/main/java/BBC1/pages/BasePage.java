package BBC1.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;


public class BasePage {
    static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitLoadPage(long timeToWait) {
        new WebDriverWait(driver, Duration.ofSeconds(timeToWait)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitVisibilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWait));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitElementToBeClickable(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWait));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void moveToElement(WebElement element) {
        Actions moveTo = new Actions(driver);
        moveTo.moveToElement(element);
    }

    public static WebElement getTextLocator(String locator, String text) {
        // must contain locator with '%s' element
        return driver.findElement(xpath(String.format(
                locator, text
        )));
    }

    public static void clickOnElement(WebElement element) {
        waitElementToBeClickable(30, element);
        element.click();
    }

    public void enterText(WebElement elementNeededText, String textForSearching) {
        elementNeededText.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), textForSearching, Keys.ENTER);
    }

    public void enterText(WebElement elementNeededText, String textForSearching, WebElement element) {
        elementNeededText.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), textForSearching);
        element.click();
    }
}