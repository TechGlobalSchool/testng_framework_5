package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TechGlobalIFramesPage extends TechGlobalBasePage {

    public TechGlobalIFramesPage(){
        super();
    }

    @FindBy(css = "#name_form > p")
    public WebElement inputHeader;

    @FindBy(css = "#form_frame")
    public WebElement iFrameId;
}
