package BBC1.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.util.Map;

public class Form extends BasePage{

    public void fillForm(Map<String, String> values,String locator) {
        values.forEach((key, value) -> getTextLocator(locator, String.valueOf(key))
                .sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), String.valueOf(value)));
    }

    public Form(WebDriver driver) {
        super(driver);
    }
}
