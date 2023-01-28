package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TechGlobalIFramesPage extends TechGlobalBasePage {

    public TechGlobalIFramesPage() {
        super();
    }

    @FindBy(css = "#name_form > p")
    public WebElement inputHeader;

    @FindBy(css = "#form_frame")
    public WebElement iFrameId;

    @FindBy(css = ".input")
    public List<WebElement> inputFields;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "result")
    public WebElement resultText;



}
