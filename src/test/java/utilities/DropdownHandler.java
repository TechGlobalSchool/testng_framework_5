package utilities;

import org.openqa.selenium.WebElement;

import java.util.List;

public class DropdownHandler {

    //Create a method that takes a dropdown, dropdown options and optionText that you want to click
    public static void clickOnDropdownOption(WebElement dropdown, List<WebElement> dropdownOptions, String optionText){
        dropdown.click();
        for (WebElement dropdownOption : dropdownOptions) {
            if(dropdownOption.getText().equals(optionText)){
                dropdownOption.click();
                break;
            }
        }
    }
}
