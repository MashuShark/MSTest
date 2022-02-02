package BBC1.pages;
import org.openqa.selenium.WebDriver;
import java.util.Map;


public class Form extends BasePage{

    public void fillForm(Map<String, String> values) {
        for ( Map.Entry entry: values.entrySet())
            UsersQuestionsPage.getTextXpath(String.valueOf(entry.getKey()))
                    .sendKeys(String.valueOf(entry.getValue()));
    }

    public Form(WebDriver driver) {
        super(driver);
    }
}
