package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TechGlobalMultipleWindowsPage extends TechGlobalBasePage{

    public TechGlobalMultipleWindowsPage(){super();}

    @FindBy(css = ".MultipleWindows_link__JB372")
    public List<WebElement> links;

    public void clickOnLink(String linkText){
        for (WebElement link : links) {
            if(link.getText().equals(linkText)){
                link.click();
                break;
            }
        }
    }
}
