package Loremipsum;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RadioButton {

    /**
     * values:
     * paras
     * words
     * bytes
     * lists
     */

    @FindBy(xpath = "//tbody//input[@type='radio']")
    private  List<WebElement> RadioButton;

    public void SetValue(String value){
        int Size = RadioButton.size();  // finding the number of Radio buttons

        for(int i=0; i < Size; i++){ // starts the loop from first Radio button to the last one

            String val = RadioButton.get(i).getAttribute("value");
            // Radio button name stored to the string variable, using 'Value' attribute

            if (val.equalsIgnoreCase(value)){   // equalsIgnoreCase is ignore case(upper/lower)
                             // selecting the Radio button if its value is same as that we are looking for
                RadioButton.get(i).click();
                break;
            }
        }

    }
}
